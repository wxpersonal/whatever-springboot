//package me.weix.whatever.config;
//
//import com.google.common.collect.Maps;
//import com.zaxxer.hikari.HikariDataSource;
//
//import io.shardingsphere.core.api.MasterSlaveDataSourceFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.annotation.Order;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//@Configuration
//@EnableConfigurationProperties(ShardingMastSlaveConfig.class)
//@ConditionalOnProperty({"sharding.jdbc.data-sources.ds_master.url", "sharding.jdbc.master-slave-rule.master-data-source-name"})
//@Slf4j
//public class ShardingConfig {
//
//    @Autowired
//    private ShardingMastSlaveConfig shardingMastSlaveConfig;
//
//    @Bean(name = "shardingDataSource")
//    @Primary
//    public DataSource dataSource() throws SQLException{
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//        dataSourceMap.putAll(shardingMastSlaveConfig.getDataSources());
//
//        Properties properties = new Properties();
//        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, shardingMastSlaveConfig.getMasterSlaveRule(), new HashMap<>(), properties);
//        log.info("masterSlaveDataSource config complete");
//        return dataSource;
//    }
//
//
//
////    private void configDataSource(HikariDataSource hikariDataSource) {
////        hikariDataSource.setMaxActive(20);
////        hikariDataSource.setInitialSize(1);
////        hikariDataSource.setMaxWait(60000);
////        hikariDataSource.setMinIdle(1);
////        hikariDataSource.setTimeBetweenEvictionRunsMillis(60000);
////        hikariDataSource.setMinEvictableIdleTimeMillis(300000);
////        hikariDataSource.setValidationQuery("select 'x'");
////        hikariDataSource.setTestWhileIdle(true);
////        hikariDataSource.setTestOnBorrow(false);
////        hikariDataSource.setTestOnReturn(false);
////        hikariDataSource.setPoolPreparedStatements(true);
////        hikariDataSource.setMaxOpenPreparedStatements(20);
////        hikariDataSource.setUseGlobalDataSourceStat(true);
////        try {
////            hikariDataSource.setFilters("stat,wall,slf4j");
////        } catch (SQLException e) {
////            log.error("druid configuration initialization filter", e);
////        }
////    }
//}
