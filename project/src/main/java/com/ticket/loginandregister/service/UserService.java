package com.ticket.loginandregister.service;

import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.daoRead.IUserDAORead;
import com.ticket.loginandregister.daoWrite.IUserDAOWrite;
import com.ticket.loginandregister.redis.Redis;
import com.ticket.loginandregister.util.SendMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    Redis redis;

    @Autowired
    IUserDAORead read;

    @Autowired
    IUserDAOWrite write;

    public void SendMessage(String tel){
       //发送验证短信
        String code = SendMessageUtils.send(tel);
       //将验证短信的验证码存到缓存中
        redis.saveString("token",code);
    }

    public UserBean login(String tel,String token){
        String code = redis.getValueByKey("token");
        if(read.selectUserByTel(tel)!=null && code == token){
            return read.selectUserByTel(tel);
        }
        else if(read.selectUserByTel(tel)==null && code == token){
            //如果数据库中没有，就添加到数据库中
            UserBean userBean = new UserBean();
            userBean.setTel(tel);
            write.insertUserWithTel(userBean);
            return userBean;
        }
        //如果验证码输入错误，就返回空
        return null;
    }


}
