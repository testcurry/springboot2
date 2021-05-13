package com.testcy.boot.controller;

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

}
