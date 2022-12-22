/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Joel Corona
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {

        System.out.println(request.getRemoteAddr());
        return true;
    }    
}
