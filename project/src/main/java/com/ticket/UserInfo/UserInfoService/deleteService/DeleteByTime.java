package com.ticket.UserInfo.UserInfoService.deleteService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Shinelon on 2018/6/10.
 */

public class DeleteByTime implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时删除");
    }

}
