package io.spring.test.dao;

import io.spring.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<User> userMapper =
            new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }
            };

    public void add(User user) {
        this.jdbcTemplate.update(
                "insert into users(id, name, password, email) " +
                        "values(?,?,?,?)",
                user.getId(), user.getName(), user.getPassword(), user.getEmail());
    }
    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                this.userMapper, id);
    }
    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id", this.userMapper);
    }
    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }
    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }
    public void update(User user) {
        this.jdbcTemplate.update(
                "update users set name = ?, password = ?, email = ?, where id = ? ", user.getName(), user.getPassword(), user.getEmail(),
                user.getId());
    }
}
