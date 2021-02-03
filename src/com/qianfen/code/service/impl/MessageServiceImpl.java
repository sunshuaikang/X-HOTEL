package com.qianfen.code.service.impl;


import com.qianfen.code.dao.MessageDao;
import com.qianfen.code.dao.impl.MessageDaoImpl;
import com.qianfen.code.entity.Message;
import com.qianfen.code.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao = new MessageDaoImpl();


    @Override
    public List<Message> getAllMessage() {
        List<Message> list = messageDao.selectAllMessage();
        return list;
    }

    @Override
    public int addMessage(Message message) {
        int i = messageDao.insertMessage(message);
        return i;
    }

    @Override
    public List<Message> getMessageCondition(String condition) {
        List<Message> list = messageDao.selectMessageByCondition(condition);
        return list;
    }
}
