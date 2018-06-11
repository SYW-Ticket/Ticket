package com.ticket.yang;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.UserInfoService.deleteService.AyTestJob;
import com.ticket.UserInfo.UserInfoService.deleteService.DeleteByTime;
import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.userInfoReadDAO.IUserinfoOrder;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.OutOfTimeYang;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
/**
 * Created by Shinelon on 2018/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class testCaseyang {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IUserInfoDAO userInfoDAO;

    @Autowired
    private IUserinfoOrder userinfoOrder;

    @Test
    public void  testCase2(){

        /*测试通过*/
      /*  UserBean userBean = userInfoDAO.ModifyPasswordFirst("123456789");   */
        userInfoDAO.ModifyPassword("123456789","11231");

    }
    /*测试通过*/
    @Test
    public void  testCase3(){
        try {
            userInfoService.ModifyPasswordService("123456789","15322");
        } catch (EqualsException e) {
            e.printStackTrace();
        }
    }




    //测试订单的逻辑
    @Test
    public void testCase4(){
        try {
            userinfoOrder.selectOrder("13554244942",0);
        } catch (OutOfTimeYang outOfTimeYang) {
            outOfTimeYang.printStackTrace();
        }

    }

    //测试删除成功
    @Test
    public void  testCase5(){
        int i = userInfoDAO.deleteOrderById(4);
        System.out.println(i);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //查询数量   成功
    @Test
    public void testCase6(){
        int i = userinfoOrder.checkOrderNum(1);

    }

    @Test
    public void  testCase7(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);

        List<Order> orders = userinfoOrder.selectHistoryListOrder(time);

    }





    @Test
    public void  testCase8(){

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = null;

        try {
            sched = sf.getScheduler();
            JobDetail job = newJob(DeleteByTime.class)
                    .withIdentity("hw_job", "hw_group")
                    .build();
            CronTrigger trigger = newTrigger()
                    .withIdentity("hw_trigger", "hw_trigger_group")
                    .withSchedule(cronSchedule("0/1 * * * * ?"))
                    .build();

            sched.scheduleJob(job, trigger);

            sched.shutdown();

        } catch (SchedulerException e) {
            //TODO
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void  testCase10(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-quartz.xml");

    }


    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    @Test
    public void test9(){
        try {

            Scheduler scheduler = schedulerFactory.getScheduler();

            //判断是否有AyTestJob类，有代表任务类在执行任务，定时器已经启动了，停止它
            if(scheduler.getJobDetail(new JobKey("AyTestJob")) != null){
                //定时器关闭
                scheduler.deleteJob(new JobKey("AyTestJob"));
                System.out.println("定时器已经关闭了！！！");
                //没有的话，说明定时器没有启动，启动它
            }else{
                //获得定义的AyTestJob
                JobDetail myJobDetail = new JobDetailImpl("AyTestJob",Scheduler.DEFAULT_GROUP, AyTestJob.class);
                //定义出发器，每1秒触发一次
                Trigger myTrigger = new CronTriggerImpl("AyTestTrigger",
                        Scheduler.DEFAULT_GROUP, "0/1 * * * * ?");
                //设置Job任务类和触发器
                scheduler.scheduleJob(myJobDetail, myTrigger);
                //启动定时器！！！
                scheduler.start();
                System.out.println("每隔10秒的定时器已经启动了........");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
