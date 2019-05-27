//package me.weix.whatever.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @author weix
// */
//@Data
//@ConfigurationProperties(prefix = "sharding.jdbc.conf")
//public class ShardingMastSlaveConfig {
//
//    private Map<String, HikariDataSource> dataSource = new HashMap<>();
//
//    private MasterSlaveRuleConfiguration masterSlaveRule;
//
//    private Properties props = new Properties();
//}
