package com.ticket.loginandregister.util;


import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class LogWriter  {

   private static Logger logger = Logger.getLogger(LogWriter.class);

   //日志打印工具类
    public static void writer(String message) {
            logger.info(message);
    }
}
