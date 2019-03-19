package me.weix.whatever.config;

import io.shardingsphere.core.api.MasterSlaveDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author weix
 */
@Configuration
@EnableConfigurationProperties(ShardingMastSlaveConfig.class)
@Slf4j
public class ShardingConfig {

    @Autowired
    private ShardingMastSlaveConfig shardingMastSlaveConfig;

    @Bean(name = "shardingDataSource")
    @Primary
    public DataSource dataSource() throws SQLException{
        Map<String, DataSource> dataSourceMap = new HashMap<>();


        dataSourceMap.putAll(shardingMastSlaveConfig.getDataSources());

        Properties properties = new Properties();
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, shardingMastSlaveConfig.getMasterSlaveRule(), new HashMap<>(), shardingMastSlaveConfig.getProps());
        log.info("masterSlaveDataSource config complete");
        return dataSource;
    }

}
