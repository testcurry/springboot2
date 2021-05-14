package com.testcy.boot.controller;

import javafx.beans.binding.ObjectExpression;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class CommonAnnationController {

    @RequestMapping("/car/{id}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id) {

        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        return map;

    }

    /*
    {
        "pv":  {
            "id": "3",
            "username": "lisi"
                },
        "name": "lisi",
        "id": 3
    }
     */
    @RequestMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCarByOwner(@PathVariable("id") Integer id,
                                             @PathVariable("username") String name,
                                             @PathVariable Map<String, String> pv,
                                             @RequestHeader("User-Agent") String userAgent,
                                             @RequestHeader Map<String, String> header,
                                             @RequestParam("age") Integer age,
                                             @RequestParam("interest") List<String> interests,
                                             @RequestParam Map<String, String> params,
                                             @CookieValue("JSessionID") String cookieValue,
                                             @CookieValue("JSessionID") Cookie cookies) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", header);
        map.put("age", age);
        map.put("interests", interests);
        map.put("params", params);
        map.put("cookieValue", cookieValue);
        map.put("cookies", cookies);
        return map;

    }

    @PostMapping("/save")
    public Map save(/*@RequestParam("username") String name,
                                    @RequestParam("password") String password,*/
            @RequestBody String body) {

        HashMap<String, String> map = new HashMap<>();
//        map.put("name", name);
//        map.put("pwd", password);
        map.put("body", body);
        return map;
    }

    ///cars/sell;low=34;brand=byd,audi,yd
    //spring boot默认是禁用了矩阵变量的功能
    // 我们需要手动开启，UrlPathHelper进行解析路径参数，
    // removeSemicolonContent是支持矩阵变量的属性，默认是true
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path) {

        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

//    /boss/1;age=20/2;age=10

    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge,
                    @PathVariable("bossId") String bossId,
                    @PathVariable("empId") String empId){

        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        map.put("bossId", bossId);
        map.put("empId", empId);
        return map;
    }

}
