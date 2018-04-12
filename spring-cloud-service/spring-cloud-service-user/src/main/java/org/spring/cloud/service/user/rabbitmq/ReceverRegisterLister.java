package org.spring.cloud.service.user.rabbitmq;

import org.spring.cloud.service.api.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceverRegisterLister {

    @RabbitListener(queues = "register-queue")
    @RabbitHandler
    public void proccess(User user) {
        System.out.println(user);
    }
}
