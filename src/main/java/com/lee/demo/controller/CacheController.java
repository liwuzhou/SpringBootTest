package com.lee.demo.controller;

import com.lee.demo.entity.User;
import com.lee.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);


    @GetMapping("/getUserWithCache")
    public String getUserWithCache(){

        String userId = "1";

        User user = userService.getUser(userId);
        logger.info("userId-->" + user.getUserId() + "  userName-->" + user.getUserName());
        User user1 = userService.getUser(userId);
        logger.info("userId-->" + user1.getUserId() + "  userName-->" + user1.getUserName());
        User user2 = userService.getUser(userId);
        logger.info("userId-->" + user2.getUserId() + "  userName-->" + user2.getUserName());
        return "cacheTestEnd";

    }

}
