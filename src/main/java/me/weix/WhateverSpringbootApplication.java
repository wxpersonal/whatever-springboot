package me.weix;

//import me.weix.whatever.common.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan
public class WhateverSpringbootApplication {

	public static void main(String[] args) {

        SpringApplication.run(WhateverSpringbootApplication.class, args);
    }
}
