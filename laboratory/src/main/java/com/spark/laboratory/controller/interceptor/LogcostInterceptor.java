package com.spark.laboratory.controller.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogcostInterceptor implements HandlerInterceptor {

    long start = System.currentTimeMillis();

    //preHandle是在请求执行前执行的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        start = System.currentTimeMillis();

        Object user = request.getSession().getAttribute("user");
        if (user == null || user.equals(""))  {
            response.sendRedirect("/index.html");
            return false;
        }

        return true;
        //返回true,postHandler和afterCompletion方法才能执行
        // 否则false为拒绝执行，起到拦截器控制作用
    }

    //postHandler是在请求结束之后,视图渲染之前执行的,但只有preHandle方法返回true的时候才会执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Interception cost="+(System.currentTimeMillis()-start));
    }

    //afterCompletion是视图渲染完成之后才执行,同样需要preHandle返回true，
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //该方法通常用于清理资源等工作
    }
}
