package com.ticket.yang;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.userInfoReadDAO.IUserinfoOrder;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        userinfoOrder.selectOrder(0);

    }



}
