package org.spring.cloud.gateway.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author allen
 * @note
 * <p>
 *  LOGIN-SERVICE 的网关服务
 * </p>
 * API网关的重要知识点：
 * 1.它作为系统的统一入口,屏蔽了系统内部各个微服务的细节。
 * 2.它可以与服务治理框架结合，实现自动化的服务实例维护以及负载均衡的路由转发。
 * 3.它可以实现接口权限校验与微服务业务逻辑的解耦
 * 4.通过服务网关中的过滤器，在各个生命周期中去校验请求的内容，将原本在对外服务层做的校验迁移，保证微服务是无状态性，同时降低了微服务的测试难度。
 */

@SpringBootApplication
@EnableZuulProxy
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
