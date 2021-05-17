package com.testcy.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        log.info("preHandle执行了。。。:{}",handler);
//        String requestURI = request.getRequestURI();
//        log.info("拦截的请求路径是：{}",requestURI);

        //登陆检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            //放行
            return true;
        }
        //拦截，并跳转到登陆页
        request.setAttribute("msg", "请先登录...");
//        response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle执行了。。。:{}",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion执行了。。。:{}",ex);
    }

}
