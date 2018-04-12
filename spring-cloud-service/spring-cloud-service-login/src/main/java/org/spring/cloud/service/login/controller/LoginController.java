package org.spring.cloud.service.login.controller;

import java.util.Map;

import org.spring.cloud.service.api.model.User;
import org.spring.cloud.service.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

@RestController
@RequestMapping(value="api/login")
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getByName(@RequestParam(value = "name") String name,@RequestParam(value="pwd",defaultValue="") String pwd) {
        Map<String,Object> result = Maps.newHashMap();
        User user = userService.getUserByName(name);
        if (user !=  null && pwd.equalsIgnoreCase(user.getPassword()) ) {
             result.put("code",0);
             result.put("msg","登录成功!");
             return result;
        }
        result.put("code",-101);
        result.put("msg","登录失败");
        return result;
    }
}
