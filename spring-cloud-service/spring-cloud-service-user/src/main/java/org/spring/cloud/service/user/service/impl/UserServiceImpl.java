package org.spring.cloud.service.user.service.impl;


import org.apache.log4j.Logger;
import org.spring.cloud.service.api.dao.UserDao;
import org.spring.cloud.service.api.model.User;
import org.spring.cloud.service.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    
    private UserDao userDao;
    @Override
    public User findById(Integer id) {
        logger.info("===<call findById>===");
        return userDao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        logger.info("===<call saveUser>===");
        userDao.save(user);
    }

    @Override
    public User findByUserName(String name) {
        logger.info("===<call findByUserName>===");
       return userDao.findByName(name);
    }

    @Override
    public boolean checkEmailIsExist(String email) {
        logger.info("===<call checkEmailIsExist>===");
        return false;
    }

    @Override
    public boolean checkTelIsExist(String email, Integer countryID) {
        logger.info("===<call checkTelIsExist>===");
        return false;
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

}
