package com.qianfen.code.service;

import com.qianfen.code.entity.RoomType;

import java.util.List;


public interface RoomTypeService {
    /**
     * 获得全部的房间类型信息
     * @return
     */
    public List<RoomType> getAllRoomType();

    /**
     * 添加一个房间类型
     * @param roomType
     * @return
     */
    public int addRoomType(RoomType roomType);

    /**
     * 修改房间类型
     * @param roomType
     * @return
     */
    public int editRoomType(RoomType roomType);

    /**
     * 删除房间类型
     * @param id
     * @return
     */
    public int deleteRoomType(int id);
}
