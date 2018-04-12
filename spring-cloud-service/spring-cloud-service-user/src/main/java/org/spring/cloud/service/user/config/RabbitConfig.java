package org.spring.cloud.service.user.config;

import org.spring.cloud.service.api.constants.Constants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Note 用于配置队列，交换器，路由等高级信息。
 * @author allen
 *
 */
@Configuration
public class RabbitConfig {

    
    @Bean
    public Queue registerQueue() {
        return new Queue(Constants.RABBITMQ_REGISTER_QUEUE);
    }
}
