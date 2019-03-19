//package me.weix.whatever.config.dataSource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@Slf4j
//public class DataSourceConfig {
//
//    @Value("${dataSource.write.url}")
//    private String writeUrl;
//
//    @Value("${dataSource.write.driverClassName}")
//    private String writeDriverClassName;
//
//    @Value("${dataSource.write.username}")
//    private String writeUserName;
//
//    @Value("${dataSource.write.password}")
//    private String writePassword;
//
//    @Value("${dataSource.read1.url}")
//    private String read1Url;
//
//    @Value("${dataSource.read1.driverClassName}")
//    private String read1DriverClassName;
//
//    @Value("${dataSource.read1.username}")
//    private String read1UserName;
//
//    @Value("${dataSource.read1.password}")
//    private String read1Password;
//
//    @Value("${dataSource.read2.url}")
//    private String read2Url;
//
//    @Value("${dataSource.read2.driverClassName}")
//    private String read2DriverClassName;
//
//    @Value("${dataSource.read2.username}")
//    private String read2UserName;
//
//    @Value("${dataSource.read2.password}")
//    private String read2Password;
//
//    @Bean(name = "writeDataSource")
//    @Primary
//    public DataSource writeDataSource() {
//
//        log.debug("----------------writeDataSource init------------------");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(writeUrl);
//        dataSource.setDriverClassName(writeDriverClassName);
//        dataSource.setUsername(writeUserName);
//        dataSource.setPassword(writePassword);
//        return dataSource;
//    }
//
//    @Bean(name = "readDataSource1")
//    public DataSource readdataSource1() {
//
//        log.debug("----------------readDataSource1 init------------------");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(read1Url);
//        dataSource.setDriverClassName(read1DriverClassName);
//        dataSource.setUsername(read1UserName);
//        dataSource.setPassword(read1Password);
//        return dataSource;
//    }
//
//    @Bean(name = "readDataSource2")
//    public DataSource readDataSource2() {
//
//        log.debug("----------------readDataSource2 init------------------");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(read2Url);
//        dataSource.setDriverClassName(read2DriverClassName);
//        dataSource.setUsername(read2UserName);
//        dataSource.setPassword(read2Password);
//        return dataSource;
//    }
//
//}