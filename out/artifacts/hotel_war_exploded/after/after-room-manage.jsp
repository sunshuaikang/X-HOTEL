<%--
  Created by IntelliJ IDEA.
  User: 87421
  Date: 2021/2/3
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台房间类型管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/after/after-room-manage.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <div class="page-header" style="text-align: center">
            <h1>房间类型管理</h1>
        </div>
    </header>
    <div class="button-wrap">
        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#add-room-type">添加类型</button>
    </div>
    <div class="room-type-wrap">
        <table class="table table-bordered">
           <tr>
               <th>房间编号</th>
               <th>类型名称</th>
               <th>房间照片</th>
               <th>房间面积</th>
               <th>房间床宽</th>
               <th>房间价格</th>
               <th>房间等级</th>
               <th>备注信息</th>
               <th>修改操作</th>
               <th>删除操作</th>
           </tr>
           <c:forEach items="${lists}" var="roomType">
                <tr>
                    <td style="vertical-align: middle;">${roomType.id}</td>
                    <td style="vertical-align: middle;">${roomType.name}</td>
                    <td ><img src="${roomType.picture}" alt=""></td>
                    <td style="vertical-align: middle;">${roomType.area}</td>
                    <td style="vertical-align: middle;">${roomType.bedWidth}</td>
                    <td style="vertical-align: middle;">${roomType.price}</td>
                    <td style="vertical-align: middle;">${roomType.level}</td>
                    <td style="vertical-align: middle;">${roomType.remark}</td>
                    <td style="vertical-align: middle;">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#${roomType.id}">修改类型</button>
                        <%-- 修改房间类型的弹框 --%>
                        <div class="modal fade" id="${roomType.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form action="${pageContext.request.contextPath}/roomTypeServlet" method="POST">
                                        <%-- 因为这里用了baseDao 所以在这里设置了一个隐藏域 --%>
                                        <input type="hidden" name="method" value="editRoomType">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="">修改房间类型</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td><input type="text" name="id" class="form-control" readonly="readonly" value="${roomType.id}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="name" class="form-control" value="${roomType.name}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="picture" class="form-control" value="${roomType.picture}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="area" class="form-control" value="${roomType.area}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="bedWidth" class="form-control" value="${roomType.bedWidth}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="price" class="form-control" value="${roomType.price}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="level" class="form-control" value="${roomType.level}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="text" name="remark" class="form-control" value="${roomType.remark}" aria-describedby="basic-addon1"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                                            <button type="submit" class="btn btn-primary">确认修改</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </td>
                    <td style="vertical-align: middle;"><button type="button" class="btn btn-info">删除类型</button></td>
                </tr>
           </c:forEach>
        </table>
    </div>


<%--添加房间类型的弹框--%>
    <div class="modal fade" id="add-room-type" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form action="" method="POST">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加房间类型</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered">
                       <tr>
                           <td><input type="text" class="form-control" placeholder="请输入类型名称" aria-describedby="basic-addon1"></td>
                       </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="请输入照片链接" aria-describedby="basic-addon1"></td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="请输入房间面积" aria-describedby="basic-addon1"></td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="请输入房间窗宽" aria-describedby="basic-addon1"></td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="请输入房间价格" aria-describedby="basic-addon1"></td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="请输入房间等级" aria-describedby="basic-addon1"></td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="请输入备注信息" aria-describedby="basic-addon1"></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" data-dismiss="modal">取消添加</button>
                    <button type="submit" class="btn btn-primary">确认添加</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
