package com.smartcity.mapper;

import com.smartcity.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    private static UserMapper instance = new UserMapper();
    public static UserMapper getInstance(){return instance;}

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setSurname(resultSet.getString("surname"));
        user.setName(resultSet.getString("name"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
        user.setUpdatedDate(resultSet.getDate("updated_date").toLocalDate());

        return user;
    }
}
