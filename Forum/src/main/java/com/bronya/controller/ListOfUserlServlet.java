package com.bronya.controller;

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

@WebServlet("/manager/userListServlet")
public class ListOfUserlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=(sPage==null||sPage.equals(""))?1:Integer.parseInt(sPage);
        int pageSize =5;
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);

        UserService userService =new UserServiceImpl();
        List<User> userList = userService.findByPage(page,pageSize);

        req.setAttribute("userList",userList);
        int userCount=userService.getCount();
//        System.out.println("userCount  "+userCount);
        req.setAttribute("userCount",userCount);
        req.setAttribute("pageCount",userCount%pageSize==0?userCount/pageSize:userCount/pageSize+1);

        //测试代码
//        PrintWriter out=resp.getWriter();
//        out.println("<h1>测试点1</h1>");
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }
}
