<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            color: black;
            text-align: center;
            padding: 10px 0;
        }
    </style>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/manager/"}>
    <style>
        ul{
            list-style: none;
            padding: 0px;
        }
        li img{
            font-size: 1.5em;
            max-height: 1em;
            max-width: 1em;
        }
    </style>
</head>
<body>
    <div>
        <h2>管理员</h2>
    </div>
    <a href="heart.html" target="right">管理员首页</a>
    <a href="../user/logout" target="_parent">注销</a>
    <ul>
        <li><img src="../images/_shexiangtou.png"><a href="online.jsp" target="right">查看在线人数</a></li>
        <li><img src="../images/yonghuguanli.png"><a href="userListServlet" target="right">用户管理</a></li>
        <li><img src="../images/tieziguanli.png"><a href="newsListManager.get" target="right">帖子管理</a></li>
        <li><img src="../images/liuyanguanli.png"><a href="disListManager.get" target="right">评论管理</a></li>
    </ul>
</body>
</html>
