package com.lee.demo.controller;

import com.lee.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @ApiOperation(value="获取用户信息", notes="根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String",paramType = "path")
    @GetMapping("/index")
    public String index(@PathParam("userId") String userId){
        //String userId = "1";
        return userService.getUser(userId).toString();
    }

    @GetMapping("/updateSalary")
    public String salary(){

        userService.updateSalary();
        return "update salary success";
    }
}
