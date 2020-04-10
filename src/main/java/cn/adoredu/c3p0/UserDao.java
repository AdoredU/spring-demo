package cn.adoredu.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() {
        String sql = "INSERT INTO user VALUES (?,?,?)";
        int rows = jdbcTemplate.update(sql, 3, "teacher", "teacher");
        System.out.println("userDao add...");
        System.out.println(rows);
    }
}
