package com.ticket.loginandregister;

import com.ticket.loginandregister.DAORead.IUserDAORead;
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
    private IUserDAORead userDAO;


    @Test
    public void testCase1(){
        userDAO.selectUser();

    }

}
