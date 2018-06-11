package com.ticket.UserInfo.UserInfoService.deleteService;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by Shinelon on 2018/6/10.
 */
public class AyTestJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //jobExecutionContext可以获得你想要的关于这个定时器的一切
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        Scheduler scheduler = jobExecutionContext.getScheduler();
        Trigger trigger = jobExecutionContext.getTrigger();
        System.out.println(jobDetail.getClass().getName());
        System.out.println("在这里处理项目的任务逻辑......");
    }
}
