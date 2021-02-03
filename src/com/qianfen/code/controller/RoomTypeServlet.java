package com.qianfen.code.controller;


import com.qianfen.code.entity.RoomType;
import com.qianfen.code.service.RoomTypeService;
import com.qianfen.code.service.impl.RoomTypeServiceImpl;
import com.qianfen.code.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/roomTypeServlet")
public class RoomTypeServlet extends BaseServlet {

    private RoomTypeService roomTypeService = new RoomTypeServiceImpl();

    /**
     * 前台展示所有房间类型
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAllRoomType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<RoomType> list = roomTypeService.getAllRoomType();
        request.setAttribute("lists",list);
        request.getRequestDispatcher("/before/before-index.jsp").forward(request,response);
    }

    /**
     * 后台展示所有有房间类型
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void afterGetAllRoomType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<RoomType> list = roomTypeService.getAllRoomType();
        request.setAttribute("lists",list);
        request.getRequestDispatcher("/after/after-room-manage.jsp").forward(request,response);
    }

    /**
     * 修改房间类型的操作
     * @param request
     * @param response
     */
    public void editRoomType(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

    }

    /**
     * 添加房间类型
     * @param request
     * @param response
     */
    public void addRoomType(HttpServletRequest request,HttpServletResponse response){

    }

    /**
     * 删除房间类型
     * @param request
     * @param response
     */
    public void deleteRoomType(HttpServletRequest request,HttpServletResponse response){

    }
}
