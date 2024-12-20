package com.bronya.controller;

import com.bronya.module.Discussion;
import com.bronya.module.News;
import com.bronya.module.User;
import com.bronya.service.UserService;
import com.bronya.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/newsList")
public class ListOfNewsUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService =new UserServiceImpl();
        List<News> newsList = userService.findAllNews();
        req.setAttribute("newsList",newsList);

        List<User> userList = userService.findAll();
        req.setAttribute("userList",userList);

        List<Discussion> discussionList = userService.findAllDiscussion();
        req.setAttribute("discussionList",discussionList);
        //测试代码
//        PrintWriter out=resp.getWriter();
//        out.println("<h1>测试点1</h1>");
        req.getRequestDispatcher("newsList.jsp").forward(req,resp);
    }
}
