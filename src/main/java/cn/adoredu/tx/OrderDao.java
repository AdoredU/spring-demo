package cn.adoredu.tx;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void reduceMoney() {
        String sql = "UPDATE orders SET money=money-? WHERE username=?";
        jdbcTemplate.update(sql, "1000", "Tom");
    }

    public void addMoney() {
        String sql = "UPDATE orders SET money=money+? WHERE username=?";
        jdbcTemplate.update(sql, "1000", "Jerry");
    }
}
