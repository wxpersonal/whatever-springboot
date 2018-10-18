package me.weix.whatever.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import me.weix.whatever.config.dataSource.DataSourceType;
import me.weix.whatever.config.dataSource.DynamicDataSource;
import me.weix.whatever.config.dataSource.DynamicDataSourcePlugin;
import me.weix.whatever.config.dataSource.DynamicDataSourceTransactionManager;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration
@MapperScan(basePackages = "me.weix.whatever.mapper")
public class MyBatisConfig {

    @Autowired
    private Environment env;


    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        conf.setLogicDeleteValue(env.getProperty("mybatis-plus.global-config.logic-delete-value"));
        conf.setLogicNotDeleteValue(env.getProperty("mybatis-plus.global-config.logic-not-delete-value"));
        conf.setIdType(Integer.parseInt(env.getProperty("mybatis-plus.global-config.id-type")));
        return conf;
    }

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);
        return paginationInterceptor;
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("writeDataSource") DataSource masterDataSource,
                                         @Qualifier("readDataSource1") DataSource readDataSource1,
                                         @Qualifier("readDataSource2") DataSource readDataSource2) {
        Map<Object, Object> map = new HashMap<>();
        map.put(DataSourceType.master.getName(), masterDataSource);
        map.put(DataSourceType.slave.getName() + 1, readDataSource1);
        map.put(DataSourceType.slave.getName() + 2, readDataSource2);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(map);
        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();

        /**
         * 指定数据源
         */
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        /**
         *  下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
         */
        sqlSessionFactoryBean.setGlobalConfig(globalConfiguration());
        sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis-plus.typeAliasesPackage"));
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis-plus.mapper-locations")));

        /**
         * 数据源切换
         */
        Integer readSize = Integer.parseInt(env.getProperty("jdbc.readSize"));
        DynamicDataSourcePlugin dynamicDataSourcePlugin = new DynamicDataSourcePlugin(readSize);
        sqlSessionFactoryBean.setPlugins(new Interceptor[] { dynamicDataSourcePlugin });
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置读写库事务管理器
     */
    //todo 未释放线程资源 treadlocal   可已自定义事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {
        return new DynamicDataSourceTransactionManager(dynamicDataSource);
    }
}