package com.xxx.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session=request.getSession();
        //登录注册忘记密码不能拦截
        String path=request.getRequestURI();
        if(path.indexOf("index")!=-1||path.indexOf("login")!=-1){
            return true;
        }

        if (session.getAttribute("user")!=null){
            //用户已登录
            System.out.println("已登录");
            return true;
        }else {
            System.out.println("未登录");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}

