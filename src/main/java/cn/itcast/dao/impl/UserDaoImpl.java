package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void add(User user) {
        String sql = "insert into user(name,age,category,`desc`) values(?,?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getCategory(),user.getDesc());
    }

    @Override
    public List<User> list(String name, Integer min, Integer max, String category) {
        /*String sql = "select * from user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));*/
        String sql = "select * from user where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        if(name != null && !"".equals(name)) {
            stringBuilder.append(" and name like ? ");
            params.add("%"+name+"%");
        }

        if(min != null && max != null) {
            stringBuilder.append(" and age >= ? and age <= ? ");
            params.add(min);
            params.add(max);
        }else {
            if(min != null) {
                stringBuilder.append(" and age >= ?");
                params.add(min);
            }else if(max != null) {
                stringBuilder.append(" and age <= ?");
                params.add(max);
            }
        }

        if(category != null && !"".equals(category)) {
            stringBuilder.append(" and category like ?");
            params.add("%"+category+"%");
        }


        return jdbcTemplate.query(stringBuilder.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
