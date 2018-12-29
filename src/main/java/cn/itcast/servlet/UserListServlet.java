package cn.itcast.servlet;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //修改原来查询所有用户的代码,接受客户端传递的条件参数
        String name = request.getParameter("name");
        String minAge = request.getParameter("minAge");
        String maxAge = request.getParameter("maxAge");
        String category = request.getParameter("category");
        Integer min = null;
        try {
             min = Integer.parseInt(minAge);
        } catch (NumberFormatException e) {

        }
        Integer max = null;
        try {
             max = Integer.parseInt(maxAge);
        } catch (NumberFormatException e) {

        }


        //调用业务层获取获取所有的用户List信息。
        //将用户List信息转化JSON响应给客户端
        UserService userService = new UserServiceImpl();
        List<User> users = userService.list(name,min,max,category);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(users);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
