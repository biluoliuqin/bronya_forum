package com.bronya.controller;

import com.bronya.service.ManagerService;
import com.bronya.service.impl.ManagerServiceIpml;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/deleteDis.do")
public class DeleteDisServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("disId");
        int disId= (sId==null||sId.equals(""))?0:Integer.parseInt(sId);

        PrintWriter out =resp.getWriter();

        ManagerService managerService =new ManagerServiceIpml();
        if (managerService.deleteDis(disId)){
            out.println("<script>alert('删除评论成功：disId: "+disId+"');window.location.href='disListManager.get'</script>");
        }else {
            out.println("<script>alert('删除评论失败：disId: "+disId+"');window.location.href='disListManager.get'</script>");
        }
        out.close();
    }
}
