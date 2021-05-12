package com.testcy.boot.controller;

import com.testcy.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){
        System.out.println("账号=="+"name"+"\n");
        System.out.println("密码=="+"pwd"+"\n");
        System.out.println(person.getUserName());
        return person;
    }

}
