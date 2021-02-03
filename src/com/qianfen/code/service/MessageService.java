package com.qianfen.code.service;


import com.qianfen.code.entity.Message;

import java.util.List;

public interface MessageService {
    /**
     * 获取全部的留言信息
     * @return
     */
    public List<Message> getAllMessage();

    /**
     * 添加一条留言信息
     * @param message
     * @return
     */
    public int addMessage(Message message);

    /**
     * 根据条件查询留言信息
     * @param condition
     * @return
     */
    public List<Message> getMessageCondition(String condition);
}
