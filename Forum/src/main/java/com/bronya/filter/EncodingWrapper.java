package com.bronya.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EncodingWrapper extends HttpServletRequestWrapper {

    public EncodingWrapper(HttpServletRequest request){
        super(request);
    }

    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        if (value!=null){
            try{
                //解决URL中文乱码问题
                byte[] bytes = value.getBytes("ISO-8859-1");
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

}
