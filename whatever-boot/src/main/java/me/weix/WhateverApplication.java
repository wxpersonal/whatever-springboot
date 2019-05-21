package me.weix;

import io.shardingsphere.jdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * @author weix
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SpringBootConfiguration.class})
@ServletComponentScan
@EnableTransactionManagement

public class WhateverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhateverApplication.class, args);
    }

}
