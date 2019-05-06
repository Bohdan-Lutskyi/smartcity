package com.smartcity.dao;


import com.smartcity.domain.User;
import com.smartcity.exception.DBOperationException;
import com.smartcity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.Optional;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template;

    @Autowired
    public UserDaoImpl(DataSource dataSource){this.template = new JdbcTemplate(dataSource);}

    @Override
    public Optional<User> create(User user) {
        try {
            template.update(
                    Queries.SQL_CREATE, user.getEmail(), user.getPassword(),
                    user.getSurname(), user.getName(), user.getPhoneNumber(),
                    getCurrentDate(), getCurrentDate());

            return Optional.of(user);
        }catch (Exception e){
            throw new DBOperationException("Create User exception");
        }
    }

    @Override
    public Optional<User> get(long id) {
        try {
            return Optional.ofNullable(template.queryForObject(
                    Queries.SQL_GET_BY_ID,
                    UserMapper.getInstance(),
                    id));
        }catch (Exception e){
            throw new DBOperationException("Get User exception");
        }
    }

    @Override
    public Optional<User> update(User user) {
        try {
            template.update(
                    Queries.SQL_UPDATE, user.getEmail(), user.getPassword(),
                    user.getSurname(), user.getName(), user.getPhoneNumber(),
                    getCurrentDate(), user.getId());

            return Optional.of(user);
        }catch (Exception e){
            throw new DBOperationException("Update User exception");
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            int result = template.update(Queries.SQL_DELETE, id);
            return result > 0;
        }catch (Exception e){
            throw new DBOperationException("Delete User Exception");
        }
    }

    private interface Queries{
        String SQL_CREATE = "insert into Users (email, password, surname, " +
                "name, phone_number, created_date, updated_date) " +
                "values (?,?,?,?,?,?,?)";

        String SQL_GET_BY_ID = "select * from Users where id = ?";

        String SQL_UPDATE = "update Users set " +
                "email = ?, password = ?, surname = ?, name = ?, " +
                "phone_number = ?, updated_date = ? where id = ?";

        String SQL_DELETE = "delete from Users where id = ?";
    }
        private static Date getCurrentDate(){
            return new Date(System.currentTimeMillis());
    }
}
