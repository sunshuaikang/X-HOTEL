package com.qianfen.code.controller;


import com.qianfen.code.entity.Message;
import com.qianfen.code.entity.User;
import com.qianfen.code.service.MessageService;
import com.qianfen.code.service.impl.MessageServiceImpl;
import com.qianfen.code.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/messageServlet")
public class MessageServlet extends BaseServlet {
    private MessageService messageService = new MessageServiceImpl();

    /**
     * 获取全部的留言信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> messageList = messageService.getAllMessage();
        request.setAttribute("messageList",messageList);
        request.getRequestDispatcher("/before/leave-message.jsp").forward(request,response);
    }

    /**
     * 添加一条留言信息
     * @param request
     * @param response
     */
    public void addMessage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession(false).getAttribute("user");
        int userId = user.getId();
        String value = request.getParameter("value");
        Message message = new Message(userId, value);
        int i = messageService.addMessage(message);
        if(i==1){
            response.sendRedirect(request.getContextPath()+"/messageServlet?method=getAllMessage");
        }
    }

    /**
     * 根据条件查询留言信息
     * @param request
     * @param response
     */
    public void getMessageByCondition(HttpServletRequest request,HttpServletResponse response){

    }
}
