package com.ticket.loginandregister.realm;

import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.daoRead.IUserDAORead;
import com.ticket.loginandregister.daoWrite.IUserDAOWrite;
import com.ticket.loginandregister.redis.Redis;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    Redis redis;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    IUserDAORead read;

    @Autowired
    IUserDAOWrite write;

    @Override
    public String getName() {
        return "UserRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获得用户所输入的用户名和密码对象
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String tel = usernamePasswordToken.getUsername();
        char[] tokenpassword = usernamePasswordToken.getPassword();
        String codetoken = new String(tokenpassword);
        //根据用户所输入的用户名获得实体类对象
        String code = redis.getValueByKey("token");
        final String TOKEN = code;
        UserBean userBean = read.selectUserByTel(tel);
        if(userBean!=null && code.equals(codetoken)){
            final String TEL = tel;
            //发送登陆消息给日志处理器，书写成日志保存在本地
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("老用户登陆成功，登陆手机号为："+TEL+"  "+"用户输入的验证码为："+TOKEN);
                }
            });

            org.apache.shiro.session.Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user",userBean);
            return new SimpleAuthenticationInfo(tel,code,getName());
        }
        else if(userBean==null && code.equals(codetoken)){
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
            org.apache.shiro.session.Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user",userBean);
            return new SimpleAuthenticationInfo(tel,code,getName());
        }
        //发送登陆消息给日志处理器，书写成日志保存在本地
        final String TEL = tel;
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("用户登陆失败，验证码输入错误，尝试登陆手机号为"+TEL+"  "+"用户输入的验证码为："+TOKEN);
            }
        });
        throw new IncorrectCredentialsException("验证码输入错误");
    }



}
