package com.ticket.loginandregister.util;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            LogWriter.writer(textMessage.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
