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
        ConfigurableApplicationContext run = SpringApplication.run(WhateverSpringbootApplication.class, args);
        SpringContextUtil.setApplicationContext(run);

        Map<String, Object> services = run.getBeansWithAnnotation(org.springframework.stereotype.Service.class);
        for(Object service : services.values()) {
            try {
                Method initMapper = service.getClass().getMethod("initMapper");
                initMapper.invoke(service);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
