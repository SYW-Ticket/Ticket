package com.ticket.UserInfo.UserInfoService.deleteService;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.redis.IRedis;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shinelon on 2018/6/10.
 */

public class DeleteByTime implements Job {

    @Autowired
    private IRedis red;

    @Autowired
    private IUserInfoDAO userInfoDAO;




    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        int id = jobDataMap.getInt("id");

        int i = userInfoDAO.deleteOrderById(id);


        if (i>0){

        }

    }

}
