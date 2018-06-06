package com.ticket.loginandregister.util;


import org.apache.log4j.Logger;

public class LogWriter {

   private static Logger logger = Logger.getLogger(LogWriter.class);

   public static void writeLog(String msg){
       logger.info(msg);
   }

}
