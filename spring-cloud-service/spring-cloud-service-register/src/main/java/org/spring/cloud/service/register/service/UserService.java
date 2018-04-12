package org.spring.cloud.service.register.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.apache.commons.lang3.StringUtils;
import org.spring.cloud.service.api.constants.Constants;
import org.spring.cloud.service.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserRegisterSender userRegisterSender;

    @HystrixCommand(fallbackMethod = "commonError")
    public String register(User user) {
        String postForObject = restTemplate.postForObject("http://USER-SERVICE/user/center/save",
                user, String.class);
        if (StringUtils.isBlank(postForObject)) {
            return "register error";
        }
        userRegisterSender.send(Constants.RABBITMQ_REGISTER_QUEUE, user);
        return postForObject;
    }

    @HystrixCommand(fallbackMethod = "commonError")
    public User findById(Integer id) {
        return restTemplate.getForObject("http://USER-SERVICE/user/center/byId?id={1}", User.class,
                id);
    }



    public String commonError() {
        return "operator error ";
    }
}
