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
    <title>用户查看个人订单页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/before/before-see-my-order.css">
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
    <c:forEach items="${orderList}" var="order">
    <div class="my-order-item">
        <table class="table table-bordered">
            <tr>
                <th>房间类型</th>
                <td>${order.roomType}</td>
                <th>入住时间</th>
                <td>${order.startTime}</td>
                <th>离开时间</th>
                <td>${order.endTime}</td>
            </tr>
            <tr>
                <th>交易金额</th>
                <td>${order.amount}</td>
                <th>订单备注</th>
                <td>${order.remark}</td>
                <th>订单状态</th>
                <td>
                    <c:if test="${order.status == true}">
                        订单未完成
                    </c:if>
                    <c:if test="${order.status == false}">
                        订单已完成
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="6" style="border: none"></td>
            </tr>
            <tr>
                <td colspan="6" style="border: none"></td>
            </tr>
            <tr>
                <td colspan="6" style="text-align: center">
                    <c:if test="${order.status == true}">
                        <form action="${pageContext.request.contextPath}/orderServlet" method="POST">
                            <input type="hidden" name="method" value="cancelOrder">
                            <input type="hidden" name="id" value="${order.id}">
                            <button type="submit" class="btn btn-danger">取消订单</button>
                        </form>
                    </c:if>
                    <c:if test="${order.status == false}">
                        <button type="button" class="btn btn-info">订单已经完成</button>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>
    </c:forEach>
<%--    <div class="my-order-item">--%>

<%--    </div>--%>
</article>
</body>
</html>
