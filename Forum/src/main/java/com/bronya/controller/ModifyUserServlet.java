package com.bronya.controller;

import com.bronya.module.User;
import com.bronya.service.UserService;
import com.bronya.service.impl.UserServiceImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//修改候选人
@WebServlet("/user/mod.do")
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        user.setUserId(Integer.parseInt(req.getParameter("id")));
        user.setUserName(req.getParameter("name"));
        user.setPwd(req.getParameter("pwd"));
//        user.setHobby(req.getParameter("hobby"));

        PrintWriter out =resp.getWriter();

        UserService userService =new UserServiceImpl();
        System.out.println("userService.modify(user):"+userService.modify(user));
        if (userService.modify(user)){
            out.println("<script>alert('修改用户成功：id:"+user.getUserId()+"');window.location.href='list'</script>");
        }else {
            out.println("<script>alert('修改用户失败：id:"+user.getUserId()+"');window.location.href='list'</script>");
        }
        out.close();
    }
}
