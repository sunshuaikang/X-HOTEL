package com.qianfen.code.controller;

import com.qianfen.code.entity.Order;
import com.qianfen.code.entity.User;
import com.qianfen.code.service.OrderService;
import com.qianfen.code.service.impl.OrderServiceImpl;
import com.qianfen.code.utils.BaseServlet;
import com.qianfen.code.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    public void getMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession(false).getAttribute("user");
        int id = user.getId();
        List<Order> orderList = orderService.getMyOrder(id);
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/before/before-see-my-order.jsp").forward(request,response);
    }

    /**
     * 获得全部的订单信息 -- 没有分页的形式
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Order> orderList = orderService.getAllOrder();
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/after/after-order-manage.jsp").forward(request,response);
    }

    /**
     * 获得全部的订单信息，分页的形式
     * @param request
     * @param response
     */
    public void getAllOrderByPage(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        //1.获得记录的总数
        List<Order> list = orderService.getAllOrder();
        int dataCount = list.size();
        //2.定义每页显示的条数
        int pageSize = 1;
        //3.调用工具类PageUtil计算分页的总数
        PageUtil pageUtil = new PageUtil(pageSize, dataCount);
        int pageCount = pageUtil.getPageCount();
        //4.从前端获取当前页码数
        String pageNo = request.getParameter("pageNo");
        if(pageNo == null){
            pageNo = "1";
        }
        //5.调用分页的查询方法，查询数据
        List<Order> orderList = orderService.getAllOrderByPage(Integer.parseInt(pageNo), pageSize);
        //6.将数据存储到request域对象中，方便jsp中获取数据
        request.setAttribute("pageNo",Integer.parseInt(pageNo));
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/after/after-order-manage.jsp").forward(request,response);
    }

    /**
     * 取消订单
     * @param request
     * @param response
     */
    public void cancelOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int i = orderService.cancelOrder(Integer.parseInt(id));
        if(i==1){
            response.sendRedirect(request.getContextPath()+"/orderServlet?method=getMyOrder");
        }else {
            response.getWriter().print("对不起，订单无法取消");
        }
    }

}
