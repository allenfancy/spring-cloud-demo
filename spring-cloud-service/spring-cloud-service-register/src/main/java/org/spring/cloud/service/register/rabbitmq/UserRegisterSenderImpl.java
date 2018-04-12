package org.spring.cloud.service.register.rabbitmq;

import org.spring.cloud.service.api.model.User;
import org.spring.cloud.service.register.service.UserRegisterSender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterSenderImpl implements UserRegisterSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void send(String queue, User user) {
        rabbitTemplate.convertAndSend(queue, user);
    }
}
