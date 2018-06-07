package com.ticket.loginandregister.service;

import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.daoRead.IUserDAORead;
import com.ticket.loginandregister.daoWrite.IUserDAOWrite;
import com.ticket.loginandregister.redis.Redis;
import com.ticket.loginandregister.util.SendMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    Redis redis;

    @Autowired
    IUserDAORead read;

    @Autowired
    IUserDAOWrite write;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void SendMessage(String tel){
       //发送验证短信
        String code = SendMessageUtils.send(tel);
       //将验证短信的验证码存到缓存中
        redis.saveString("token",code);
        final String CODE = code;
        final String TEL = tel;
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("验证码发送成功，发送手机号为："+TEL+"   "+"发送的验证码为："+CODE);
            }
        });
    }

    public UserBean login(String tel,String token){

        String code = redis.getValueByKey("token");
        final String TOKEN = token;
        UserBean userBean = read.selectUserByTel(tel);
        if(userBean!=null && code.equals(token)){
            final String TEL = tel;
            //发送登陆消息给日志处理器，书写成日志保存在本地
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("老用户登陆成功，登陆手机号为："+TEL+"  "+"用户输入的验证码为："+TOKEN);
                }
            });
            return userBean;
        }
        else if(userBean==null && code.equals(token)){
            //如果数据库中没有，就添加到数据库中
            UserBean user = new UserBean();
            user.setTel(tel);
            write.insertUserWithTel(user);
            final String TEL = tel;
            //发送登陆消息给日志处理器，书写成日志保存在本地
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("新用户登陆成功，登陆手机号为"+TEL+"  "+"用户输入的验证码为："+TOKEN);
                }
            });
            return user;
        }
        //发送登陆消息给日志处理器，书写成日志保存在本地
        final String TEL = tel;
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("用户登陆失败，验证码输入错误，尝试登陆手机号为"+TEL+"  "+"用户输入的验证码为："+TOKEN);
            }
        });
        //如果验证码输入错误，就返回空
        return null;
    }


}
