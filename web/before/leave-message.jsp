<%--
  Created by IntelliJ IDEA.
  User: 第一小组项目
  Date: 2021/2/2
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户的留言模块</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/before/leave-message.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="page-header" style="text-align: center">
        <h1>留言专栏<small>留下你的踪迹吧</small></h1>
    </div>

    <div class="find-message-wrap">
        <form class="form-inline">
            <div class="form-group">
                <input type="text" name="" class="form-control" placeholder="请输入留言内容关键字">
            </div>
            <div class="form-group">
                <input type="date" name="" class="form-control" placeholder="请选择留言日期">
            </div>
            <button type="submit" class="btn btn-default" >查询留言</button>
        </form>
    </div>

    <div class="add-message-wrap">
        <form action="${pageContext.request.contextPath}/messageServlet" method="POST">
            <input type="hidden" name="method" value="addMessage">
        <div class="write-message-wrap">
            <textarea name="value"  class="form-control" aria-describedby="basic-addon1"></textarea>
        </div>
        <div class="add-message-button">
            <button type="submit" class="btn btn-info">发表评论</button>
        </div>
        </form>
    </div>

    <div class="message-wrap">
        <c:forEach items="${messageList}" var="message">
            <div class="message-item">
                <div class="message-value">
                    <p>${message.value}</p>
                </div>
                <div class="message-notice">
                    <span>留言用户：${message.userId}</span>
                    <span>发布时间：${message.date}</span>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
