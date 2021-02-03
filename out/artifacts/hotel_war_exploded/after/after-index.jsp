<%--
  Created by IntelliJ IDEA.
  User: 第一小组项目
  Date: 2021/2/2
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台主页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/after/after-index.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <article>
        <a href="${pageContext.request.contextPath}/userServlet?method=getAllUser">
            <div class="left common">
                用户管理
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/orderServlet?method=getAllOrderByPage">
            <div class="right common">
                订单管理
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/roomTypeServlet?method=afterGetAllRoomType">
            <div class="right common">
                房间管理
            </div>
        </a>
    </article>
</body>
</html>
