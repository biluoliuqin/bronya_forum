package com.bronya.controller;

import com.bronya.module.User;
import com.bronya.service.UserService;
import com.bronya.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user/register")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 5,     // 5 MB
        maxRequestSize = 1024 * 1024 * 5 * 5) // 25 MB
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        User user = new User();
        String path = "/photo";
        String savedDir = req.getServletContext().getRealPath(path);
        File uploadDir = new File(savedDir);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        for (Part part : req.getParts()) {
            String fieldName = part.getName();
            String fileName = part.getSubmittedFileName();

            if (fileName == null || fileName.isEmpty()) {
                // 处理普通表单字段
                String value = new String(part.getInputStream().readAllBytes(), "UTF-8");
                switch (fieldName) {
                    case "username":
                        user.setUserName(value);
                        break;
                    case "nickname":
                        user.setNickname(value);
                        break;
                    case "password":
                        user.setPwd(value);
                        break;
                    case "gender":
                        user.setGender(value);
                        break;
                }
            } else {
                // 处理文件上传字段
                fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                File file = new File(uploadDir, fileName);
                part.write(file.getAbsolutePath());
                user.setHeadSculpture(req.getContextPath() + path + "/" + fileName);
            }
        }

        PrintWriter out = resp.getWriter();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        user.setReg_time(time);
        UserService userService = new UserServiceImpl();
        if (userService.add(user)) {
            out.println("<script>window.location.href='login.jsp'</script>");
        } else {
            out.println("<script>alert('注册失败：" + user + "');window.location.href='register.jsp'</script>");
        }
        out.close();
    }
}
