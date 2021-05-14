package com.testcy.boot.controller;

import com.testcy.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ParamsTestController {


    @ResponseBody
    @PostMapping("/saveUser")
    public Person saveUser(Person person){
        return person;
    }

    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletResponse response,
                            HttpServletRequest request){

        map.put("mapMsg", "world666");
        model.addAttribute("modelMsg", "hello666");
        request.setAttribute("msg", "HelloWorld");
        Cookie cookie = new Cookie("c1", "v1");
        cookie.setMaxAge(60*60*24*7);
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success1";
    }


    @GetMapping("/success1")
    @ResponseBody
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("mapMsg") String mapMsg,
                       @RequestAttribute("modelMsg") String modelMsg,
//                       @RequestAttribute("respMsg") String respMsg,
                       HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        map.put("reqMsg", msg);
        map.put("reqMsg1", msg1);
        map.put("mapMsg", mapMsg);
        map.put("modelMsg", modelMsg);
//        map.put("respMsg", respMsg);
        return map;
    }

}
