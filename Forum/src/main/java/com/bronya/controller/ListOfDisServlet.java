package com.bronya.controller;

import com.bronya.module.Discussion;
import com.bronya.module.News;
import com.bronya.service.ManagerService;
import com.bronya.service.impl.ManagerServiceIpml;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/disListManager.get")
public class ListOfDisServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=(sPage==null||sPage.equals(""))?1:Integer.parseInt(sPage);
        int pageSize =8;
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);

        ManagerService managerService = new ManagerServiceIpml();
        List<Discussion> disList= managerService.findAllDisByPage(page,pageSize);

        req.setAttribute("disList",disList);
        int disCount= managerService.getDisCount();

        req.setAttribute("disCount",disCount);
        req.setAttribute("pageCount",disCount%pageSize==0?disCount/pageSize:disCount/pageSize+1);

        req.getRequestDispatcher("disListOfManager.jsp").forward(req,resp);
    }
}
