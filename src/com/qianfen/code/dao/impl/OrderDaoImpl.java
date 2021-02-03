package com.qianfen.code.dao.impl;


import com.qianfen.code.dao.OrderDao;
import com.qianfen.code.entity.Order;
import com.qianfen.code.utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private BaseDao baseDao = new BaseDao();
    @Override
    public List<Order> selectOrderByUser(int id) {
        String sql = "select * from t_order where userId = ? and flag = 1";
        Object[] param = {id};
        try {
            List<Order> list = baseDao.query(sql, param, Order.class);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> selectAllOrder() {
        String sql = "select * from t_order o inner join t_user u on o.userId=u.id";
        Object[] param={};
        try {
            List<Order> list = baseDao.query(sql, param, Order.class);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> selectAllOrderByPage(int start, int pageSize) {
        String sql = "select * from t_order o inner join t_user u on o.userId=u.id limit ?,?";
        Object[] param = {start,pageSize};
        try {
            List<Order> list = baseDao.query(sql, param, Order.class);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> selectOrderByCondition(String condition) {

        return null;
    }

    @Override
    public int insertOrder(Order order) {
        return 0;
    }

    @Override
    public int updateFlag(int id) {
        String sql = "update t_order set flag = 0 where id = ?";
        Object[] param={id};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

}
