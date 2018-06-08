package com.ticket.film.util;

import com.ticket.film.entity.Film;
import com.ticket.film.service.FilmService;
import com.ticket.loginandregister.redis.Redisimpl.Redisimpl;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class FilmHotListener implements MessageListener {
    @Resource
    private FilmService filmService;
    @Resource
    private Redisimpl redisimpl;
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String filmIdForHot_id = textMessage.getText();
            redisimpl.incr(filmIdForHot_id);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
