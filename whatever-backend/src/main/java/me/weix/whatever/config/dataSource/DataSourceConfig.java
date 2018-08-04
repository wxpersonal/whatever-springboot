package me.weix.whatever.config.dataSource;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    private static Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "jdbc.");
    }

    @Bean(name = "writeDataSource")
    @Primary
    public DataSource writeDataSource() {

        log.debug("----------------writeDataSource init------------------");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("write.url"));
        datasource.setDriverClassName(propertyResolver.getProperty("write.driverClassName"));
        datasource.setUsername(propertyResolver.getProperty("write.username"));
        datasource.setPassword(propertyResolver.getProperty("write.password"));
        return datasource;
    }

    @Bean(name = "readDataSource1")
    public DataSource readDataSource1() {

        log.debug("----------------readDataSource1 init------------------");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("read1.url"));
        datasource.setDriverClassName(propertyResolver.getProperty("read1.driverClassName"));
        datasource.setUsername(propertyResolver.getProperty("read1.username"));
        datasource.setPassword(propertyResolver.getProperty("read1.password"));
        return datasource;
    }

    @Bean(name = "readDataSource2")
    public DataSource readDataSource2() {

        log.debug("----------------readDataSource2 init------------------");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("read2.url"));
        datasource.setDriverClassName(propertyResolver.getProperty("read2.driverClassName"));
        datasource.setUsername(propertyResolver.getProperty("read2.username"));
        datasource.setPassword(propertyResolver.getProperty("read2.password"));
        return datasource;
    }

}