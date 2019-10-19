package com.lee.demo.service.impl;

import com.lee.demo.dao.SalaryDao;
import com.lee.demo.dao.UserDao;
import com.lee.demo.entity.User;
import com.lee.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    SalaryDao salaryDao;

    @Override
    @Cacheable("user")
    public User getUser(String userId) {
        delay();
        return userDao.queryUserById(userId);
    }

    @Override
    @Transactional
    public void updateSalary() {
        salaryDao.updateSalaryByUserId("1","100");

        //int i = 10/0;

        salaryDao.updateSalaryByUserId("2","200");
    }

    private void delay(){

        try {
            Long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
