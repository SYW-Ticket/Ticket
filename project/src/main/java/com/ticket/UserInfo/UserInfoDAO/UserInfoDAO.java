
package com.ticket.UserInfo.UserInfoDAO;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Repository
public class UserInfoDAO extends SqlSessionDaoSupport implements IUserInfoDAO {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    /**
     *  短信验证码验证方法
     *  by  杨国帅   at  2018/6/6  16：17
     * @param message 输入的字符串
     * @return 返回验证结果  boolean
     */
    @Override
    public boolean CheckShortMessage(String message) {




        return false;
    }
}