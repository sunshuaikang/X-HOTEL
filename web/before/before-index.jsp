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
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/before/before-index.css">
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

    <%-- 房间类型展示部分 --%>
    <article>
        <c:forEach items="${lists}" var="roomType">
        <div class="common-item">
            <%-- 房间类型的照片 --%>
            <div class="left">
                <img src="${roomType.picture}" alt="">
            </div>
            <%-- 房间类型的其他信息 --%>
            <div class="right">
                <table class="table table-bordered">
                    <tr>
                        <th>房间类型名称：</th>
                        <td>${roomType.name}</td>
                    </tr>
                    <tr>
                        <th>房间类型床宽：</th>
                        <td>${roomType.bedWidth}</td>
                    </tr>
                    <tr>
                        <th>房间类型价格：</th>
                        <td>${roomType.price}</td>
                    </tr>
                    <tr>
                        <th>房间类型等级：</th>
                        <td>${roomType.level}</td>
                    </tr>
                    <tr>
                        <th>温馨提示信息：</th>
                        <td>${roomType.remark}</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#${roomType.id}">预定房间</button>
                            <%-- 预定房间的弹框 --%>
                            <div class="modal fade" id="${roomType.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form action="${pageContext.request.contextPath}/roomTypeServlet" method="POST">
                                            <input type="hidden" name="method" value="addRoomType">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="">请确认预定信息</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <th>房间类型名称：</th>
                                                    <td>
                                                        <input type="text" class="form-control" name="roomType" readonly="readonly" value="${roomType.name}" aria-describedby="basic-addon1">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>入住酒店时间：</th>
                                                    <td>
                                                        <input type="date" class="form-control" name="startTime" value="${roomType.bedWidth}" aria-describedby="basic-addon1">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>离开酒店时间：</th>
                                                    <td>
                                                        <input type="date" class="form-control" name="endTime" value="${roomType.bedWidth}" aria-describedby="basic-addon1">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>房间类型价格：</th>
                                                    <td>
                                                        <input type="text" class="form-control" name="amount" readonly="readonly" value="${roomType.price}" aria-describedby="basic-addon1">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>房间类型等级：</th>
                                                    <td>
                                                        <input type="text" class="form-control" name="" readonly="readonly" value="${roomType.level}" aria-describedby="basic-addon1">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>用户备注信息：</th>
                                                    <td>
                                                        <input type="text" class="form-control" name="remark" placeholder="请输入订单的备注信息" aria-describedby="basic-addon1">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消预定</button>
                                            <button type="submit" class="btn btn-primary">确认预定</button>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        </c:forEach>
    </article>
</body>
</html>
