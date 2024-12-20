package com.bronya.controller;

import com.bronya.module.Manager;
import com.bronya.service.ManagerService;
import com.bronya.service.UserService;
import com.bronya.service.impl.ManagerServiceIpml;
import com.bronya.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/deleteNews.do")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("newsId");
        int newsId= (sId==null||sId.equals(""))?0:Integer.parseInt(sId);

        PrintWriter out =resp.getWriter();

        ManagerService managerService =new ManagerServiceIpml();
        if (managerService.deleteNews(newsId)){
            out.println("<script>alert('删除帖子成功：newsId: "+newsId+"');window.location.href='newsListManager.get'</script>");
        }else {
            out.println("<script>alert('删除帖子失败：newsId: "+newsId+"');window.location.href='newsListManager.get'</script>");
        }
        out.close();
    }
}
