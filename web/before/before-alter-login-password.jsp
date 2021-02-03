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
    <title>修改用户登录密码页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/before/before-alter-login-password.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%-- 头部导航栏部分 --%>
<header>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">X-HOTEL</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/roomTypeServlet?method=getAllRoomType">网站首页</a></li>
                            <li><a href="${pageContext.request.contextPath}/userServlet?method=getMyInformation">查看个人信息</a></li>
                            <li><a href="${pageContext.request.contextPath}/userServlet?method=showMyInformation">编辑个人信息</a></li>
                            <li><a href="${pageContext.request.contextPath}/before/before-alter-login-password.jsp">修改登录密码</a></li>
                            <li><a href="${pageContext.request.contextPath}/orderServlet?method=getMyOrder">查看个人订单</a></li>
                            <li><a href="${pageContext.request.contextPath}/userServlet?method=logout">退出当前登录</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/before/before-register.jsp">注册</a></li>
                    <li><a href="${pageContext.request.contextPath}/messageServlet?method=getAllMessage">留言板块</a></li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="X-HOTEL">
                    </div>
                    <button type="submit" class="btn btn-default">查找</button>
                </form>
            </div>
        </div>
    </nav>
</header>

<article>
    <div class="update-password-wrap">
        <form action="${pageContext.request.contextPath}/userServlet" method="POST">
            <input type="hidden" name="method" value="alertPassWord">
            <table class="table table-bordered">
                <tr>
                    <th>请输入旧密码</th>
                    <td><input type="password" name="oldPassword" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <th>请输入新密码密码</th>
                    <td><input type="password" name="newPassword1" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <th>请再次输入新密码</th>
                    <td><input type="password" name="newPassword2" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <button type="submit" class="btn btn-info">确认修改密码</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</article>
</body>
</html>
