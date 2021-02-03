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
    <title>用户管理页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/after/after-user-manage.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="page-header" style="text-align: center">
        <h1>管理用户</h1>
    </div>
</header>
<article>
    <div class="user-wrap">
        <form class="form-inline" action="${pageContext.request.contextPath}/userServlet" method="POST">
            <input type="hidden" name="method" value="getUserByPhone">
            <div class="form-group">
                <input type="text" name="phone" class="form-control" placeholder="请输入用户手机号">
            </div>
            <button type="submit" class="btn btn-default" >查询用户</button>
        </form>
        <table class="table table-bordered">
            <tr>
                <th>用户编号</th>
                <th>用户账户</th>
                <th>用户密码</th>
                <th>用户手机</th>
                <th>用户头像</th>
                <th>用户签名</th>
                <th>重置密码</th>
                <th>删除操作</th>
<%--                <th>修改操作</th>--%>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td style="vertical-align: middle">${user.id}</td>
                    <td style="vertical-align: middle">${user.name}</td>
                    <td style="vertical-align: middle">${user.password}</td>
                    <td style="vertical-align: middle">${user.phone}</td>
                    <td style="vertical-align: middle"><img src="${user.picture}" alt=""></td>
                    <td style="vertical-align: middle">${user.sign}</td>
                    <td style="vertical-align: middle"><a href="${pageContext.request.contextPath}/userServlet?method=resetPassWord&&id=${user.id}">重置密码</a></td>
                    <td style="vertical-align: middle"><a href="${pageContext.request.contextPath}/userServlet?method=deleteUser&&id=${user.id}">删除用户</a></td>
<%--                    <td style="vertical-align: middle"><a href="${pageContext.request.contextPath}/userServlet?method=deleteUser&&id=${user.id}">修改用户</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>

</article>
</body>
</html>
