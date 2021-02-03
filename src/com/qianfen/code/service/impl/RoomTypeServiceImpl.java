package com.qianfen.code.service.impl;

import com.qianfen.code.dao.RoomTypeDao;
import com.qianfen.code.dao.impl.RoomTypeDaoImpl;
import com.qianfen.code.entity.RoomType;
import com.qianfen.code.service.RoomTypeService;

import java.util.List;


public class RoomTypeServiceImpl implements RoomTypeService {
    private RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();
    @Override
    public List<RoomType> getAllRoomType() {
        List<RoomType> list = roomTypeDao.selectAllRoomType();
        return list;
    }

    @Override
    public int addRoomType(RoomType roomType) {
        int i = roomTypeDao.insertRoomType(roomType);
        return i;
    }

    @Override
    public int editRoomType(RoomType roomType) {
        int i = roomTypeDao.updateRoomType(roomType);
        return i;
    }

    @Override
    public int deleteRoomType(int id) {
        int i = roomTypeDao.deleteRoomType(id);
        return i;
    }
}
