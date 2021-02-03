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
    <title>订单管理页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/after/after-order-manage.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <div class="page-header" style="text-align: center">
            <h1>管理订单</h1>
        </div>
    </header>
    <article>
       <div class="order-wrap">
           <form class="form-inline">
               <div class="form-group">
                   <input type="text" name="userName" class="form-control" placeholder="请输入下单用户">
               </div>
               <div class="form-group">
                   <input type="date" name="orderTime" class="form-control" placeholder="请选择下单日期">
               </div>
               <button type="submit" class="btn btn-default" >查询订单</button>
           </form>
           <table class="table table-bordered">
               <tr>
                   <th>订单编号</th>
                   <th>下单用户</th>
                   <th>房间类型</th>
                   <th>入住时间</th>
                   <th>离开时间</th>
                   <th>下单日期</th>
                   <th>交易金额</th>
                   <th>订单备注</th>
                   <th>订单状态</th>
               </tr>
               <c:forEach items="${orderList}" var="order">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.name}</td>
                        <td>${order.roomType}</td>
                        <td>${order.startTime}</td>
                        <td>${order.endTime}</td>
                        <td>${order.orderTime}</td>
                        <td>${order.amount}</td>
                        <td>${order.remark}</td>
                        <td>${order.status}</td>
                    </tr>
               </c:forEach>
           </table>
       </div>
       <%-- 分页按钮部分 --%>
        <div class="page-wrap">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-lg">
                    <%-- 如果当前页码等于1 则设置当前按钮不可以点击 --%>
                    <c:if test="${pageNo == 1}">
                        <li class="disabled">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <%-- 如果当前页码不等于1 则设置当前按钮可以点击 --%>
                    <c:if test="${pageNo != 1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/orderServlet?method=getAllOrderByPage&&pageNo=${pageNo-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <%-- 循环显示分页的数字 --%>
                    <c:forEach varStatus="data" begin="1" end="${pageCount}">
                        <c:if test="${data.count == pageNo}">
                            <li class="active"><a>${data.count}</a></li>
                        </c:if>
                        <c:if test="${data.count != pageNo}">
                            <li><a href="${pageContext.request.contextPath}/orderServlet?method=getAllOrderByPage&&pageNo=${data.count}">${data.count}</a></li>
                        </c:if>
                    </c:forEach>
                    <%-- 如果当前页码等于分页页码总数 则设置当前按钮不可以点击 --%>
                    <c:if test="${pageNo == pageCount}">
                        <li class="disabled">
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <%-- 如果当前页码不等于分页页码总数 则设置当前按钮可以点击 --%>
                    <c:if test="${pageNo != pageCount}">
                        <li>
                            <a href="${pageContext.request.contextPath}/orderServlet?method=getAllOrderByPage&&pageNo=${pageNo+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </article>
</body>
</html>
