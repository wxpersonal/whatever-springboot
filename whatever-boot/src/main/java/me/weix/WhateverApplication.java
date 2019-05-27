package me.weix;

import io.shardingsphere.jdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * 启动类
 * @author weix
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = { SpringBootConfiguration.class })
public class WhateverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhateverApplication.class, args);
    }

}
