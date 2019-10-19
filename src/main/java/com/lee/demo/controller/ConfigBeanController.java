package com.lee.demo.controller;

import com.lee.demo.entity.MyInfo;
import com.lee.demo.entity.SelfConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({MyInfo.class, SelfConfigInfo.class})
public class ConfigBeanController {

    @Autowired
    MyInfo myInfo;

    @Autowired
    SelfConfigInfo selfConfigInfo;

    @RequestMapping("/welcome")
    public String welcome(){
        return "name -->" + myInfo.getName() +" age -->" + myInfo.getAge() + " address-->" + myInfo.getAddress();
    }

    @RequestMapping("/haha")
    public String haha(){
        return "testName1-->" + selfConfigInfo.getTestName1() +" testName2-->" + selfConfigInfo.getTestName2()
            + " testName3-->" + selfConfigInfo.getTestName3();
    }
}
