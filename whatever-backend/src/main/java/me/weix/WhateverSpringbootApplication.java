package me.weix;

//import me.weix.whatever.util.SpringContextUtil;
import me.weix.whatever.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan
public class WhateverSpringbootApplication {

	public static void main(String[] args) {

        SpringApplication.run(WhateverSpringbootApplication.class, args);
    }
}
