<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
</head>
<body>
    <span>上次登录时间：${manager.lastLoginTime}</span>
    <span>欢迎 ${manager.managerName} 登陆！</span>
</body>
</html>
