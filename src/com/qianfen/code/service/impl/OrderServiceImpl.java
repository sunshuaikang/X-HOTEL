package com.qianfen.code.service.impl;


import com.qianfen.code.dao.OrderDao;
import com.qianfen.code.dao.impl.OrderDaoImpl;
import com.qianfen.code.entity.Order;
import com.qianfen.code.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<Order> getMyOrder(int id) {
        List<Order> list = orderDao.selectOrderByUser(id);
        return list;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> list = orderDao.selectAllOrder();
        return list;
    }

    @Override
    public List<Order> getAllOrderByPage(int pageNo, int pageSize) {
        int start = (pageNo-1)*pageSize;
        List<Order> list = orderDao.selectAllOrderByPage(start, pageSize);
        return list;
    }

    @Override
    public List<Order> getOrderByCondition(String condition) {
        List<Order> list = orderDao.selectOrderByCondition(condition);
        return list;
    }

    @Override
    public int addOrder(Order order) {
        int i = orderDao.insertOrder(order);
        return i;
    }

    @Override
    public int cancelOrder(int id) {
        int i = orderDao.updateFlag(id);
        return i;
    }

}
