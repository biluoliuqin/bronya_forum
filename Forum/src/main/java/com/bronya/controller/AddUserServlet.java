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
import java.text.SimpleDateFormat;
import java.util.Date;

//添加候选人
@WebServlet("/user/add.do")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date =new Date();
        //设置日期格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=simpleDateFormat.format(date);

        User user=new User();
        //id自增不用设置
        user.setUserName(req.getParameter("name"));
        user.setPwd(req.getParameter("pwd"));
        user.setGender(req.getParameter("gender"));
        String hobby="";
        for (String each:req.getParameterValues("hobby")){
            hobby=hobby+each+" ";
        }

        user.setHobby(hobby);
        user.setReg_time(time);
        PrintWriter out =resp.getWriter();

        UserService userService =new UserServiceImpl();
        if (userService.add(user)){
            out.println("<script>alert('添加用户成功："+user+"');window.location.href='list'</script>");
        }else {
            out.println("<script>alert('添加用户失败："+user+"');window.location.href='list'</script>");
        }
        out.close();
    }
}
