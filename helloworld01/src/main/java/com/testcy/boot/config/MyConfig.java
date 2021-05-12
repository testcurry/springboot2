package com.testcy.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.testcy.boot.bean.Car;
import com.testcy.boot.bean.Cat;
import com.testcy.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/*
 *proxyBeanMethods代理bean的方法
 * Full：(proxyBeanMethods = true)组件互相依赖时调成true
 *lite：(proxyBeanMethods = false)组件之间不依赖时调成false，加快启动速度
 *
 * *@Import({DBHelper.class,User.class}),导入的组件的名称默认是全类名
 * */
@Import({DBHelper.class, User.class})
@Configuration(proxyBeanMethods = false)
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:applicationContext.xml")
//开启配置绑定功能，并将Car自动注册到容器中
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    //    @ConditionalOnBean(name = "tomcat")
    @Bean
    public User user01() {
        User user = new User("zhangsan", 18);
        user.setCat(tomcat());
        return user;
    }

    @Bean("tom22")
    public Cat tomcat() {
        return new Cat("zhangsan");
    }

}
