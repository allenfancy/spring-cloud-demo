package org.spring.cloud.service.api.service;

import org.spring.cloud.service.api.model.User;

public interface UserService {

    User findById(Integer id);

    void saveUser(User user);

    User findByUserName(String name);

    boolean checkEmailIsExist(String email);

    boolean checkTelIsExist(String email, Integer countryID);

    int deleteUser(Integer id);
}
