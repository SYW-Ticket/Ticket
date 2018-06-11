package com.ticket.UserInfo.util.MyselfException;

/**
 * Created by Shinelon on 2018/6/9.
 */

/**
 *  order的创建时间和查询时间超过了15分钟   即订单存在超过了15分钟  抛出异常
 */
public class OutOfTimeYang extends Exception {

    public OutOfTimeYang(String message){
        super(message);
    }
}
