package com.ticket.loginandregister;

import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.daoRead.IUserDAORead;
import com.ticket.loginandregister.daoWrite.IUserDAOWrite;
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
public class testCase1 {
    @Autowired
    IUserDAORead userDAORead;

    @Autowired
    IUserDAOWrite UserDAOWrite;

    @Test
    public void  testCase1(){
//        UserBean userBean = new UserBean();
//        userBean.setTel("18602743162");
//        UserDAOWrite.insertUserWithTel(userBean);

        System.out.println(userDAORead.selectUserByTel("18602743162").getTel());
    }
}
