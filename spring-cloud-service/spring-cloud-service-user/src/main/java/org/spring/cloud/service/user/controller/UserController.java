package org.spring.cloud.service.user.controller;


import org.apache.log4j.Logger;
import org.spring.cloud.service.api.model.User;
import org.spring.cloud.service.api.service.UserService;
import org.spring.cloud.service.user.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/center")
public class UserController {
    
    private final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/byName", method = RequestMethod.GET)
    public User getByName(@RequestParam(value = "name") String name) {
        logger.info("===<call byName>===");
        return userService.findByUserName(name);
    }

    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public User getByName(@RequestParam(value = "id") Integer id) {
        logger.info("===<call byId>===");
        return userService.findById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String getByName(@RequestBody User user) {
        logger.info("===<call save>===");
        userService.saveUser(user);
        return "OK";
    }


    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getName() {
        logger.info("===<call name>===");
        return appConfig.getName();
    }

}
