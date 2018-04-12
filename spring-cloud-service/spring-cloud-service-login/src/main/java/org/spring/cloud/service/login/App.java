package org.spring.cloud.service.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 登录中心
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@ComponentScan
@EnableFeignClients // User Feign Client
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
