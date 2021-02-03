package com.qianfen.code.dao.impl;

import com.qianfen.code.dao.UserDao;
import com.qianfen.code.entity.User;
import com.qianfen.code.utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private BaseDao baseDao = new BaseDao();
    @Override
    public int addUser(User user) {
        String sql = "insert into t_user(name,password) values(?,?)";
        try {
            Object[] param = {user.getName(),user.getPassword()};
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public User selectUserByName(String name) {
        String sql = "select * from t_user where name = ?";
        Object[] param = {name};
        User user = null;
        try {
            List<User> list = baseDao.query(sql,param,User.class);
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equals(name)){
                    user = list.get(i);
                }
            }
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
        return user;
    }

    @Override
    public User selectUserById(int id) {
        String sql = "select * from t_user where id=?";
        Object[] param={id};
        try {
            List<User> list = baseDao.query(sql, param, User.class);
            return list.get(0);
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

    @Override
    public List<User> selectAllUser() {
        String sql = "select * from t_user";
        Object[] param = {};
        try {
            List<User> list = baseDao.query(sql, param,User.class);
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

    @Override
    public List<User> selectAllUserByPage(int start, int pageSize) {
        String sql = "select * from t_user limit ?,?";
        Object[] param={start,pageSize};
        try {
            List<User> list = baseDao.query(sql, param, User.class);
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

    @Override
    public List<User> selectUserByPhone(String phone) {
        String sql = "select * from t_user where phone =?";
        Object[] param={phone};
        try {
            List<User> list = baseDao.query(sql, param,User.class);
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

    @Override
    public int updatePassWord(int id) {
        String sql = "update t_user set password = ? where id=?";
        Object[] param={"000000",id};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from t_user where id = ?";
        Object[] param={id};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set name=?,phone=?,picture=?,sign=? where id=?";
        Object[] param={user.getName(),user.getPhone(),user.getPicture(),user.getSign(),user.getId()};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePassWordById(int id,String newPassWord){
        String sql = "update t_user set password=? where id = ?";
        Object[] param={newPassWord,id};
        try {
            int update = baseDao.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
