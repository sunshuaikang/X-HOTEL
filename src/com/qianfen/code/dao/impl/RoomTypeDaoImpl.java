package com.qianfen.code.dao.impl;

import com.qianfen.code.dao.RoomTypeDao;
import com.qianfen.code.entity.RoomType;
import com.qianfen.code.utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


public class RoomTypeDaoImpl implements RoomTypeDao {
    private BaseDao baseDao = new BaseDao();

    /**
     * 查询全部房间类型 没有分页的形式
     * @return
     */
    @Override
    public List<RoomType> selectAllRoomType() {
        String sql = "select * from t_roomtype";
        Object[] param = {};
        try {
            List<RoomType> list = baseDao.query(sql, param,RoomType.class);
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

    /**
     * 查询全部房间类型  分页的形式，但是没有完成功能，需自己完成
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<RoomType> selectAllRoomTypeByPage(int start, int pageSize) {
        return null;
    }

    /**
     * 向数据库中插入一条语句
     * @param roomType
     * @return
     */
    @Override
    public int insertRoomType(RoomType roomType) {
        String sql = "INSERT INTO t_roomtype(name, picture, area, bedWidth, price, level, remark)" +
                "VALUES (?,?,?,?,?,?,?)";
        Object[] param = {roomType.getName(),roomType.getPicture(),roomType.getArea(),
                roomType.getBedWidth(),roomType.getPrice(),roomType.getLevel(),roomType.getRemark()};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 更新数据库中的一条语句
     * @param roomType
     * @return
     */
    @Override
    public int updateRoomType(RoomType roomType) {
        String sql = "UPDATE t_roomtype SET name=?,picture=?,area=?,bedWidth=?,price=?,level=?,remark=? WHERE id=?";
        Object[] param = {roomType.getName(),roomType.getPicture(),roomType.getArea(),roomType.getBedWidth(),roomType.getPrice(),roomType.getLevel(),roomType.getRemark(),roomType.getId()};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据Id删除数据库中的一条语句
     * @param id
     * @return
     */
    @Override
    public int deleteRoomType(int id) {
        //根据主键删除房间类型
        return 0;
    }
}
