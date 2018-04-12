package org.spring.cloud.service.register;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 注册中心
 *
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan
@MapperScan("org.spring.cloud.service.api.dao")
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
