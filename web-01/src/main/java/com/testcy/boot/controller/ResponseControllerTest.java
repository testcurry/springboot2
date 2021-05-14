package com.testcy.boot.controller;

import com.testcy.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseControllerTest {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(26);
        person.setBirth(new Date());
        person.setUserName("Curry");
        return person;
    }

}
