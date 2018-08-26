package me.weix.whatever.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Slf4j
public class DataSourceConfig {

    @Value("${jdbc.write.url}")
    private String writeUrl;

    @Value("${jdbc.write.driverClassName}")
    private String writeDriverClassName;

    @Value("${jdbc.write.username}")
    private String writeUserName;

    @Value("${jdbc.write.password}")
    private String writePassword;

    @Value("${jdbc.read1.url}")
    private String read1Url;

    @Value("${jdbc.read1.driverClassName}")
    private String read1DriverClassName;

    @Value("${jdbc.read1.username}")
    private String read1UserName;

    @Value("${jdbc.read1.password}")
    private String read1Password;

    @Value("${jdbc.read2.url}")
    private String read2Url;

    @Value("${jdbc.read2.driverClassName}")
    private String read2DriverClassName;

    @Value("${jdbc.read2.username}")
    private String read2UserName;

    @Value("${jdbc.read2.password}")
    private String read2Password;

    @Bean(name = "writeDataSource")
    @Primary
    public DataSource writeDataSource() {

        log.debug("----------------writeDataSource init------------------");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(writeUrl);
        datasource.setDriverClassName(writeDriverClassName);
        datasource.setUsername(writeUserName);
        datasource.setPassword(writePassword);
        return datasource;
    }

    @Bean(name = "readDataSource1")
    public DataSource readDataSource1() {

        log.debug("----------------readDataSource1 init------------------");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(read1Url);
        datasource.setDriverClassName(read1DriverClassName);
        datasource.setUsername(read1UserName);
        datasource.setPassword(read1Password);
        return datasource;
    }

    @Bean(name = "readDataSource2")
    public DataSource readDataSource2() {

        log.debug("----------------readDataSource2 init------------------");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(read2Url);
        datasource.setDriverClassName(read2DriverClassName);
        datasource.setUsername(read2UserName);
        datasource.setPassword(read2Password);
        return datasource;
    }

}