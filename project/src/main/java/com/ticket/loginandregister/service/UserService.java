package com.ticket.loginandregister.service;

import com.ticket.loginandregister.daoRead.IUserDAORead;
import com.ticket.loginandregister.daoWrite.IUserDAOWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserDAORead read;

    @Autowired
    IUserDAOWrite write;

    public void login(String tel){

    }


}
