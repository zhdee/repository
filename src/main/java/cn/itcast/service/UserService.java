package cn.itcast.service;

import cn.itcast.pojo.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    List<User> list(String name, Integer min, Integer max, String category);
}
