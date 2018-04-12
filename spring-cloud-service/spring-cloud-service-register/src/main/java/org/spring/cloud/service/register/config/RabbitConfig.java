package org.spring.cloud.service.register.config;

import org.spring.cloud.service.api.constants.Constants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue registerQueue() {
        return new Queue(Constants.RABBITMQ_REGISTER_QUEUE);
    }
}
