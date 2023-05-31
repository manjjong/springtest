package io.spring.test.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {
    @Bean
    public DataSource drivingEx() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/drivingex");
        dataSource.setUsername("root");
        dataSource.setPassword("210601");
        return dataSource;
    }

    @Bean
    public UserDao userDao() {
        JdbcUserDao userDao = new JdbcUserDao();
        userDao.init(drivingEx());
        return userDao;
    }
}
