package com.testcy.boot.controller;

import com.testcy.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController//以字符串的形式写给页面
@Slf4j
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car() {
        log.info("请求进来了！");
        return car;
    }

    @RequestMapping("/hello")
    public String handle01() {
        return "Hello,Spring Boot2!" + "你好！";
    }

}
