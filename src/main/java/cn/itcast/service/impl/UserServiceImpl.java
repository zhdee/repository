package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> list(String name, Integer min, Integer max, String category) {
        return userDao.list(name,min,max,category);
    }
}
