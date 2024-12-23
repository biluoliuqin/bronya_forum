package com.bronya.controller;

import com.bronya.module.Discussion;
import com.bronya.module.User;
import com.bronya.service.UserService;
import com.bronya.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user/addDiscussion.do")
public class addDiscussionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        Date date =new Date();
        //设置日期格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String disTime=simpleDateFormat.format(date);

        Discussion discussion = new Discussion();
        discussion.setNewsId(Integer.parseInt(req.getParameter("newsId")));
        discussion.setUserId(Integer.parseInt(req.getParameter("userId")));
        discussion.setContent(req.getParameter("content"));
        discussion.setNickname(req.getParameter("nickname"));
        discussion.setBeDisedUserNicename((req.getParameter("beDisedUserNicename")));
        discussion.setDiscussionTime(disTime);

        PrintWriter out =resp.getWriter();

        UserService userService =new UserServiceImpl();
        if (userService.diss(discussion)){
            out.println("<script>window.location.href='newsList'</script>");
        }else {
            out.println("<script>alert('评论失败："+discussion+"');window.location.href='newsList'</script>");
        }
        out.close();
    }
}
