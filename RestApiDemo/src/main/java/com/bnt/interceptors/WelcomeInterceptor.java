package com.bnt.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Enumeration;

public class WelcomeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Enumeration<String> parameterNames = request.getParameterNames();
        if (parameterNames.hasMoreElements() == Boolean.FALSE || parameterNames.nextElement().equals("name")) {
            return true;
        } else {
            response.getWriter().write("{\n" +
                    "timestamp :"+LocalDateTime.now()+",\n"+
                    "status : 400 \n"+
                    "timestamp : Invalid Request Parameter\n"+
                    "path : "+request.getRequestURL()+"\n"+
                    "}");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(400);
            return false;
        }
    }
}
