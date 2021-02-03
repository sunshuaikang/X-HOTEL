package com.qianfen.code.dao;


import com.qianfen.code.entity.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 根据用户查询订单
     * @param id
     * @return
     */
    public List<Order> selectOrderByUser(int id);

    /**
     * 查询全部的订单 不分页
     * @return
     */
    public List<Order> selectAllOrder();

    /**
     * 查询全部的订单 分页
     * @param start
     * @param pageSize
     * @return
     */
    public List<Order> selectAllOrderByPage(int start,int pageSize);

    /**
     * 根据用户输入的条件查询订单信息
     * @param condition
     * @return
     */
    public List<Order> selectOrderByCondition(String condition);

    /**
     * 向数据库中插入一条记录
     * @param order
     * @return
     */
    public int insertOrder(Order order);

    /**
     * 更新数据库中的Flag字段
     * @return
     */
    public int updateFlag(int id);
}
