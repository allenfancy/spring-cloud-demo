package org.spring.cloud.service.login.service;

import org.spring.cloud.service.api.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="user-service"/**,fallback = UserServiceFallback.class**/)
public interface UserService {

    @RequestMapping("/user/center/byName")
    User getUserByName(@RequestParam("name")String name);

}
