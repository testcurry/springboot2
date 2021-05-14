package com.testcy.boot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Pet {

    private String name;
    private String age;
}
