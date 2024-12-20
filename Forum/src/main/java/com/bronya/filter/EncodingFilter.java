package com.bronya.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
//        System.out.println("EncodeingFilter：requestURI= "+request.getRequestURI());
        resp.setContentType("text/html;charset=utf-8");
        if (request.getMethod().equals("GET")){
            request=new EncodingWrapper(request);
        }else {
            request.setCharacterEncoding("utf-8");
        }

        chain.doFilter(request,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
