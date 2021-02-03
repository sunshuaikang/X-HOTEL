package com.qianfen.code.dao;

import com.qianfen.code.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 向数据库中添加用户信息
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 根据用户的名称查询用户
     * @param name
     * @return
     */
    public User selectUserByName(String name);

    /**
     * 根据用户的Id查询用户
     * @param id
     * @return
     */
    public User selectUserById(int id);
    /**
     * 查找全部的用户
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 查找全部的用户，分页查询
     * @param start
     * @param pageSize
     * @return
     */
    public List<User> selectAllUserByPage(int start,int pageSize);

    /**
     * 根据手机号 查询一条数据
     * @param phone
     * @return
     */
    public List<User> selectUserByPhone(String phone);

    /**
     * 更新数据库中的密码 根据ID
     * @param id
     * @return
     */
    public int updatePassWord(int id);

    /**
     * 根据id删除出一条用户记录
     * @param id
     * @return
     */
    public int deleteUser(int id);

    /**
     * 更新用户的
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据id更新密码
     * @param id
     * @return
     */
    public int updatePassWordById(int id,String newPassWord);
}
