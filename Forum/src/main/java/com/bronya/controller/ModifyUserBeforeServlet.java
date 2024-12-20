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

import java.io.PrintWriter;

//管理候选人（查看候选人列表）
@WebServlet("/user/mod")
public class ModifyUserBeforeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("id");
        int id = (sId==null||sId.equals(""))?0:Integer.parseInt(sId);
        PrintWriter out =resp.getWriter();

        UserService userService =new UserServiceImpl();
        User user =userService.get(id);
        if (user!=null){
            req.setAttribute("user",user);
            req.getRequestDispatcher("modifyUser.jsp").forward(req,resp);
        }else {
            out.println("<script>alert('修改用户失败：id: "+id+"');window.location.href='list'</script>");
        }
        out.close();
    }
}
