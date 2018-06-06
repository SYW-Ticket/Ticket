package com.ticket.loginandregister.daoRead;

import com.ticket.loginandregister.bean.UserBean;

/**
 * Created by Shinelon on 2018/6/6.
 */
public interface IUserDAORead {

    UserBean selectUserByTel(String tel);

}
