package com.testcy.boot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
