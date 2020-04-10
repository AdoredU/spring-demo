package cn.adoredu.jdbc;

import cn.adoredu.ioc.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestJDBC {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring-test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void testInsert() {
        String sql = "INSERT INTO user VALUES (?, ?, ?)";
        int rows = jdbcTemplate.update(sql, 1, "admin", "123456");
        System.out.println(rows);
    }

    @Test
    public void testUpdate() {
        String sql = "UPDATE user SET password=? WHERE username=?";
        int rows = jdbcTemplate.update(sql, "654321", "admin");
        System.out.println(rows);
    }

    @Test
    public void testDelete() {
        String sql = "DELETE FROM user WHERE username=?";
        int rows = jdbcTemplate.update(sql, "admin");
        System.out.println(rows);
    }

    @Test
    public void testQuery() {
        // 查询返回一个值
        String sql = "SELECT COUNT(*) FROM user";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void testQuery2() {
        // 查询一个对象
        String sql = "SELECT * FROM user WHERE username=?";
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "admin");
        System.out.println(user);
    }

    @Test
    public void testQuery3() {
        // 查询返回对象list
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql, new MyRowMapper());
        System.out.println(userList);
    }
}

class MyRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        // 1. 从结果集中得到数据
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");

        // 2. 把数据封装到对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}
