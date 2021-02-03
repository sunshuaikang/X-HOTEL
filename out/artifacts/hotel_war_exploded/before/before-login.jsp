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
    <title>用户登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/before/before-login.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <div class="page-header">
            <h1>X-HOTEL酒店<small>第一组小项目</small></h1>
        </div>
    </header>
    <article>
        <div id="login-form">
            <form action="${pageContext.request.contextPath}/userServlet" method="POST">
            <%-- 这里因为使用了BaseServlet 所以这里设置一个隐藏域用来指出需要执行的方法名称，这里的value是对应的方法名称 --%>
            <input type="hidden" name="method" value="login">
            <table>
                <tr>
                    <td><input type="text" name="username" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <td><input type="password" name="password" class="form-control" placeholder="请输入用户密码" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="automaticLogin" value="true">  记住登录
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" class="btn btn-info">登录</button></td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/before/before-register.jsp">立即注册</a>
                    </td>
                </tr>
            </table>
        </form>
        </div>
    </article>
</body>
</html>
