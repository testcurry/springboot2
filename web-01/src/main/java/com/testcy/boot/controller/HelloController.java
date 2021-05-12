package com.testcy.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/test.jpg")
    public String hello(){
        return "aaaaa";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-zhangsan";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(){
        return "POST-zhangsan";
    }
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-zhangsan";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        return "PUT-zhangsan";
    }
}
