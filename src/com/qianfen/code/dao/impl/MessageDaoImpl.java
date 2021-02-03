package com.qianfen.code.dao.impl;


import com.qianfen.code.dao.MessageDao;
import com.qianfen.code.entity.Message;
import com.qianfen.code.utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    private BaseDao baseDao = new BaseDao();
    @Override
    public List<Message> selectAllMessage() {
        String sql = "select * from t_message";
        Object[] param = {};
        try {
            List<Message> list = baseDao.query(sql, param, Message.class);
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
    public List<Message> selectAllMessageByPage(int start, int pageSize) {
        return null;
    }

    @Override
    public int insertMessage(Message message) {
        String sql = "insert into t_message(userId,value) values(?,?)";
        Object[] param={message.getUserId(),message.getValue()};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Message> selectMessageByCondition(String condition) {
        return null;
    }
}
