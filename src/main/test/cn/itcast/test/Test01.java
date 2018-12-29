package cn.itcast.test;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class Test01 {
    @Test
    public void test01() {
        UserService userService = new UserServiceImpl();
        List<User> list = userService.list(null, 11, 18, "普通");
        System.out.println(list);
    }
}
