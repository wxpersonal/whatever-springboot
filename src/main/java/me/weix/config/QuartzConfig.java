package me.weix.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/1.
 */
@Configuration
public class QuartzConfig {

    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }
    /**
     * 设置quartz属性
     * @throws IOException
     * 2016年10月8日下午2:39:05
     */
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "ServerScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");
        return prop;
    }



}
