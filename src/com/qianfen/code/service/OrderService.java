package com.qianfen.code.service;

import com.qianfen.code.entity.Order;
import java.util.List;

public interface OrderService {
    /**
     * 获得用户自己的订单
     * @param id
     * @return
     */
    public List<Order> getMyOrder(int id);

    /**
     * 获得全部的订单
     * @return
     */
    public List<Order> getAllOrder();

    /**
     * 获得全部的订单  分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Order> getAllOrderByPage(int pageNo,int pageSize);

    /**
     * 根据条件查询订单
     * @param condition
     * @return
     */
    public List<Order> getOrderByCondition(String condition);

    /**
     * 添加一个订单记录
     * @param order
     * @return
     */
    public int addOrder(Order order);

    /**
     * 取消订单
     * @param id
     * @return
     */
    public int cancelOrder(int id);
}
