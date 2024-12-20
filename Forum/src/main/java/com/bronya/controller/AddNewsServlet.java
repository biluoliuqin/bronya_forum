package com.bronya.controller;

import com.bronya.module.News;
import com.bronya.service.UserService;
import com.bronya.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user/addNews.do")
@MultipartConfig
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        News news = new News();
        String path = "/photo";
        String savedDir = req.getServletContext().getRealPath(path);
        File uploadDir = new File(savedDir);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        for (Part part : req.getParts()) {
            String fieldName = part.getName();
            String fileName = part.getSubmittedFileName();

            if (fileName == null || fileName.isEmpty()) {
                // 处理普通表单字段
                String value = new String(part.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                switch (fieldName) {
                    case "theme":
                        news.setTheme(value);
                        break;
                    case "content":
                        news.setContent(value);
                        break;
                    case "userId":
                        news.setUserId(Integer.parseInt(value));
                        break;
                }
            } else {
                // 处理文件上传字段
                fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                File file = new File(uploadDir, fileName);
                part.write(file.getAbsolutePath());
                news.setPhotoUrl(req.getContextPath() + path + "/" + fileName);
            }
        }

        PrintWriter out = resp.getWriter();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newsTime = sdf.format(date);
        news.setNewsTime(newsTime);

        UserService userService = new UserServiceImpl();
        if (userService.addNews(news)) {
            out.println("<script>window.location.href='newsList';</script>");
        } else {
            out.println("<script>alert('新建帖子失败：" + news + "');window.location.href='newsList';</script>");
        }
        out.close();
    }
}
