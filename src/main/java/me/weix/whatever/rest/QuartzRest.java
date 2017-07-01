package me.weix.whatever.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.weix.config.quartz.QuartzJobFactory;
import me.weix.config.quartz.ScheduleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.Map;

@Api(description = "任务调度")
@Path("quartz")
public class QuartzRest {

    /**
     * 计划任务map
     */
    private static Map<String, ScheduleJob> jobMap = new HashMap<String, ScheduleJob>();

    @Autowired
    @Qualifier("scheduler")
    Scheduler scheduler;

    @ApiOperation(value = "添加一个任务")
    @POST
    @Path(value = "add")
    public String add(HttpServletRequest request) {
        System.out.println("----------------");
        ScheduleJob job = new ScheduleJob();
        job.setJobId("10001");
        job.setJobName("data_import");
        job.setJobGroup("dataWork");
        job.setJobStatus("1");
        job.setCronExpression("0/5 * * * * ?");
        job.setDesc("数据导入任务");


        JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                .withIdentity(job.getJobName(), job.getJobGroup()).build();
        jobDetail.getJobDataMap().put("scheduleJob", job);

        //表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                .getCronExpression());

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "is ok";
    }

    /**
     * 添加任务
     *
     * @param scheduleJob
     */
    public static void addJob(ScheduleJob scheduleJob) {
        jobMap.put(scheduleJob.getJobGroup() + "_" + scheduleJob.getJobName(), scheduleJob);
    }

}
