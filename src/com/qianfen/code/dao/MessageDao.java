package com.qianfen.code.dao;


import com.qianfen.code.entity.Message;

import java.util.List;

public interface MessageDao {

    /**
     * 查询全部的留言信息
     * @return
     */
    public List<Message> selectAllMessage();

    /**
     * 分页拆查新全部的留言信息
     * @param start
     * @param pageSize
     * @return
     */
    public List<Message> selectAllMessageByPage(int start,int pageSize);

    /**
     * 像数据空插入一条数据
     * @param message
     * @return
     */
    public int insertMessage(Message message);

    /**
     * 根据条加查询留言信息
     * @param condition
     * @return
     */
    public List<Message> selectMessageByCondition(String condition);
}
