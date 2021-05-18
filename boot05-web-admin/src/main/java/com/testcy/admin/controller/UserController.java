package com.testcy.admin.controller;

import com.testcy.admin.Service.CityService;
import com.testcy.admin.Service.UserService;
import com.testcy.admin.bean.City;
import com.testcy.admin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;

    @ResponseBody
    @GetMapping("/getUser")
    public User user(@RequestParam(value = "id",required = false) Integer id){
        return userService.queryUser(id);
    }

    @GetMapping("/city")
    @ResponseBody
    public City getCity(@RequestParam("id") long id){
        return cityService.queryById(id);
    }

    @PostMapping("/saveCity")
    @ResponseBody
    public City save(City city){
        return cityService.saveCity(city);
    }

}
