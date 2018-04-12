package org.spring.cloud.service.register.service;

import org.spring.cloud.service.api.model.User;

public interface UserRegisterSender {

    public void send(String queue, User user);
}
