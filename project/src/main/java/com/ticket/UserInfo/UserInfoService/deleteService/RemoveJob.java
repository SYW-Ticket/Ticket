package com.ticket.UserInfo.UserInfoService.deleteService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Created by Shinelon on 2018/6/11.
 */
@Service
public class RemoveJob {


    /**
     *    定时任务  用于删除
     * @param
     */
    public void testremoveJob(int id) {

        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
           /* scheduler.setJobFactory(new MyBeanJobFactory());*/
            JobBuilder jobBuilder = JobBuilder.newJob().ofType(DeleteByTime.class).withIdentity("jobBuilder");
            JobDetail jobDetail = jobBuilder.build();
            jobDetail.getJobDataMap().put("id",id);
            long nowtime = System.currentTimeMillis();
            long nows =nowtime+900000;


           /* String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/

            Date date = new Date(nows);



            SimpleTrigger cronTrigger = TriggerBuilder.newTrigger().startAt(date)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0)).build();


            scheduler.scheduleJob(jobDetail,cronTrigger);
            System.out.println(new Date());


           /* MyBeanJobFactory myBeanJobFactory = new MyBeanJobFactory();
            scheduler.setJobFactory(myBeanJobFactory);
*/            scheduler.start();

//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(5000);

//            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

//
//        try {
//           delScheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//        TriggerKey key = trigger.getKey();
//        try {
//
//            delScheduler.start();
//            delScheduler.unscheduleJob(key);// 移除触发器
//          /*  sched.resumeJob(trigger.getJobKey());*/
//            /*sched.pauseTrigger(key);// 停止触发器*/
//
////            sched.deleteJob(trigger.getJobKey());// 删除任务
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

