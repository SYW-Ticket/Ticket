package com.ticket.insertOrder.util;

import com.ticket.loginandregister.util.LogWriter;
import com.ticket.loginandregister.util.SendMessageUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class OrderSendMsgListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            SendMessageUtils.send(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
