package cn.itcast.dao;

import cn.itcast.pojo.User;

import java.util.List;

public interface UserDao {
    public void add(User user);

    List<User> list(String name, Integer min, Integer max, String category);
}
