package com.ticket.UserInfo.UserInfoService.deleteService;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.UserInfoDAO.impl.UserInfoDAO;
import com.ticket.UserInfo.redis.Redisimpl.Red;
import com.ticket.insertOrder.daoWrite.Seat_occupiedDao;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Shinelon on 2018/6/10.
 */

public class DeleteByTime implements Job {


    @Autowired
    private IUserInfoDAO userInfoDAO;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    /*    // 使得job对象可以通过注解实现依赖注入
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);*/
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-core.xml");

        UserInfoDAO userInfoOrder = classPathXmlApplicationContext.getBean(UserInfoDAO.class);
        Red red = classPathXmlApplicationContext.getBean(Red.class);
        Seat_occupiedDao seat_occupiedDao = classPathXmlApplicationContext.getBean(Seat_occupiedDao.class);

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        int id = jobDataMap.getInt("id");

        int costState=2;

        //删除订单
        int i = userInfoOrder.deleteOrderById(id,costState);
        if(red.getValueByKey("order"+id)==null){
            seat_occupiedDao.update_occupiedByOrderID(i);
        }

        System.out.println("订单已在数据库修改成功");

    }

}
