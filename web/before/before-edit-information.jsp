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
    <title>修改用户个人信息页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/before/before-edit-information.css">
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
    <div class="my-information-wrap">
        <%-- 用户图片展示部分 --%>
        <div class="left">
            <img src="${user.picture}" alt="">
        </div>

        <%-- 图片以外的个人信息部分 --%>
        <div class="right">
            <form action="${pageContext.request.contextPath}/userServlet" method="post">
                <input type="hidden" name="method" value="editUser">
                <input type="hidden" name="id" value="${user.id}">
            <table class="table table-bordered">
                <tr>
                    <th>用户账号</th>
                    <td><input type="text" name="name" value="${user.name}" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <th>用户手机</th>
                    <td><input type="text" name="phone" value="${user.phone}" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <th>个性签名</th>
                    <td><input type="text" name="sign" value="${user.sign}" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <th>用户头像</th>
                    <td><input type="text" name="picture" value="${user.picture}" class="form-control" aria-describedby="basic-addon1"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-info">确认修改</button>
                    </td>
                </tr>
            </table>
            </form>
        </div>

    </div>
</article>
</body>
</html>
