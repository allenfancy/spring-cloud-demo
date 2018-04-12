package org.spring.cloud.service.register.controller;

import org.apache.log4j.Logger;
import org.spring.cloud.service.api.model.User;
import org.spring.cloud.service.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Note
 * use Ribbon
 */
@RestController
@RequestMapping("api/register")
public class RegisterController {

    private final Logger logger = Logger.getLogger(RegisterController.class);
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        logger.info("===<register>===");
        return userService.register(user);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable Integer id) {
        logger.info("===<getById>===");
        return userService.findById(id);
    }
}
