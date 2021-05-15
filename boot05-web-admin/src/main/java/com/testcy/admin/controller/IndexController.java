package com.testcy.admin.controller;

import com.testcy.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController {

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {

        if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:main.html";
        }else {
            model.addAttribute("msg", "账号或密码错误!");
//            model.addAttribute("userName", user.getUserName());
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {
     /*   Object loginUser = session.getAttribute("loginUser");

        if (loginUser!=null){

            return "main";
        }else {
            model.addAttribute("msg", "会话超时，请重新登录！");
            return "login";
        }*/
        log.info("当前方法是：{}","mainPage");
        return "main";
    }

}
