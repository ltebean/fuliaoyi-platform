package com.fuliaoyi.web.interceptor;

import com.fuliaoyi.service.UserService;
import com.fuliaoyi.service.dto.UserDTO;
import com.fuliaoyi.web.annotation.LoginRequired;
import com.fuliaoyi.web.controller.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(1)
public class UserInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("token");
        UserDTO user = null;
        if (token != null) {
            user = userService.findUserByToken(token);
        }
        if (user == null) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getMethod().isAnnotationPresent(LoginRequired.class) ||
                    handlerMethod.getMethod().getDeclaringClass().isAnnotationPresent(LoginRequired.class)) {
                throw new UnauthorizedException();
            }
        } else {
            request.setAttribute("user", user);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
