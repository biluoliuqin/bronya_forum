<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>鸭鸭论坛-系统管理</title>
    <link rel="icon" type="text/x-icon" href="../images/bronya.jpg">
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
</head>
<frameset cols="190,*">
    <frame src="managerFuc.jsp">
    <frameset rows="60,*">
        <frame name="right-top" src="managerInfo.jsp">
        <frame name="right" src="heart.html">
    </frameset>
</frameset>
</html>
