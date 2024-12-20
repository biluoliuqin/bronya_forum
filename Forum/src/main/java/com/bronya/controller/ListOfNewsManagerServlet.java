package com.bronya.controller;

import com.bronya.dao.ManagerDao;
import com.bronya.dao.impl.ManagerDaoImpl;
import com.bronya.module.Manager;
import com.bronya.module.News;
import com.bronya.module.User;
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
import java.util.List;

@WebServlet("/manager/newsListManager.get")
public class ListOfNewsManagerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=(sPage==null||sPage.equals(""))?1:Integer.parseInt(sPage);
        int pageSize =8;
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);

        ManagerService managerService = new ManagerServiceIpml();
        List<News> newsList= managerService.findAllNewsByPage(page,pageSize);

        req.setAttribute("newsList",newsList);
        int newsCount= managerService.getNewsCount();
//        System.out.println("userCount  "+userCount);
        req.setAttribute("newsCount",newsCount);
        req.setAttribute("pageCount",newsCount%pageSize==0?newsCount/pageSize:newsCount/pageSize+1);

        req.getRequestDispatcher("newsListOfManager.jsp").forward(req,resp);
    }
}
