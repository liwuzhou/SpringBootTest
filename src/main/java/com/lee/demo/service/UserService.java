package com.lee.demo.service;

import com.lee.demo.entity.User;

public interface UserService {

    public User getUser(String userId);

    public void updateSalary();
}
