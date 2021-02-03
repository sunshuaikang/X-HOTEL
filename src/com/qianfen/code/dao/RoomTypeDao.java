package com.qianfen.code.dao;

import com.qianfen.code.entity.RoomType;

import java.util.List;


public interface RoomTypeDao {

    /**
     * 查询全部的房间类型
     * @return
     */
    public List<RoomType> selectAllRoomType();

    /**
     * 分页查询全部的房间类型
     * @return
     */
    public List<RoomType> selectAllRoomTypeByPage(int start,int pageSize);

    /**
     * 向数据库中插入一条语句
     * @param roomType
     * @return
     */
    public int insertRoomType(RoomType roomType);

    /**
     * 更新数据库中的一条语句
     * @param roomType
     * @return
     */
    public int updateRoomType(RoomType roomType);

    /**
     * 根据主键  删除房间类型
     * @param id
     * @return
     */
    public int deleteRoomType(int id);
}
