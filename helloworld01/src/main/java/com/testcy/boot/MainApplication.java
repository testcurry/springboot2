package com.testcy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] runBeanDefinitionNames = run.getBeanDefinitionNames();
        for (String bean:runBeanDefinitionNames){
            System.out.println(bean);
        }
    }
}
