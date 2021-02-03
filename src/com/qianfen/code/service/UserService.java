package com.qianfen.code.service;

import com.qianfen.code.entity.User;
import java.util.List;
public interface UserService {

    /**
     * service 用户注册的时候使用的方法
     * @param user
     * @return
     */
    public int register(User user);


    /**
     * 用户登录的时候使用的方法
     * @param name
     * @return
     */
    public User login(String name);

    /**
     * 获取全部的用户信息
     * @return
     */
    public List<User> getAllUser();

    /**
     * 根据id获得用户
     * @param id
     * @return
     */
    public User getUserById(int id);


    /**
     * 根据手机号 获得一条数据
     * @param phone
     * @return
     */
    public List<User> getUserByPhone(String phone);

    /**
     * 根据id重置用户的密码
     * @param id
     * @return
     */
    public int resetPassWord(int id);

    /**
     * 根据id删除出一条用户记录
     * @param id
     * @return
     */
    public int deleteUser(int id);

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    public int editUser(User user);

    /**
     * 根据id修改用户的登录密码
     * @param id
     * @return
     */
    public int alterPassWord(int id,String newPassWord);

}
