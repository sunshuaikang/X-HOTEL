package com.qianfen.code.service.impl;

import com.qianfen.code.dao.UserDao;
import com.qianfen.code.dao.impl.UserDaoImpl;
import com.qianfen.code.entity.User;
import com.qianfen.code.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int register(User user) {
        int i = userDao.addUser(user);
        return i;
    }

    @Override
    public User login(String name) {
        User user = userDao.selectUserByName(name);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = userDao.selectAllUser();
        return list;
    }

    @Override
    public User getUserById(int id) {
        User user = userDao.selectUserById(id);
        return user;
    }

    @Override
    public List<User> getUserByPhone(String phone) {
        List<User> list = userDao.selectUserByPhone(phone);
        return list;
    }

    @Override
    public int resetPassWord(int id) {
        int i = userDao.updatePassWord(id);
        return i;
    }

    @Override
    public int deleteUser(int id) {
        int i = userDao.deleteUser(id);
        return i;
    }

    @Override
    public int editUser(User user) {
        int i = userDao.updateUser(user);
        return i;
    }

    @Override
    public int alterPassWord(int id,String newPassWord) {
        int i = userDao.updatePassWordById(id,newPassWord);
        return i;
    }

}
