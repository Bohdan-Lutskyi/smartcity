package com.smartcity.dao;

import com.smartcity.domain.User;
import com.smartcity.exceptions.DbOperationException;
import com.smartcity.exceptions.NotFoundException;
import com.smartcity.mapper.UserMapper;
import com.smartcity.utils.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template;

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public User create(User user) {
        try {
            LocalDateTime currentDate = LocalDateTime.now();

            GeneratedKeyHolder holder = new GeneratedKeyHolder();
            String encryptedPassword = EncryptionUtil.encryptionPassword(user.getPassword());

            template.update(con -> {
                        PreparedStatement ps = con.prepareStatement(
                                Queries.SQL_CREATE, Statement.RETURN_GENERATED_KEYS);

                        ps.setString(1, user.getEmail());
                        ps.setString(2, encryptedPassword);
                        ps.setString(3, user.getSurname());
                        ps.setString(4, user.getName());
                        ps.setString(5, user.getPhoneNumber());
                        ps.setBoolean(6, true);
                        ps.setObject(7, currentDate);
                        ps.setObject(8, currentDate);

                        return ps;
                    },
                    holder
            );

            user.setCreatedDate(currentDate);
            user.setUpdatedDate(currentDate);
            user.setActive(true);
            user.setId(holder.getKey().longValue());

            return user;
        } catch (Exception e) {
            logger.error("Create user (id = {}) exception. Message : {}", user.getId(), e.getMessage());
            throw new DbOperationException("Create User exception");
        }
    }

    @Override
    public User get(long id) {
        try {
            User user = template.queryForObject(
                    Queries.SQL_GET_BY_ID,
                    UserMapper.getInstance(),
                    id);

            return user;
        } catch (EmptyResultDataAccessException e) {
            throw getAndLogUserNotFoundException(id);
        } catch (Exception e) {
            logger.error("Get user (id = {}) exception. Message: {}", id, e.getMessage());
            throw new DbOperationException("Get User exception");
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            User user = template.queryForObject(
                    Queries.SQL_GET_BY_EMAIL,
                    UserMapper.getInstance(),
                    email);

            return user;
        } catch (EmptyResultDataAccessException ex) {
            NotFoundException notFoundException = new NotFoundException("User no found");
            logger.error("RuntimeException. User not found(email = {}). Message: {}",
                    email,
                    notFoundException.getMessage());
            throw notFoundException;
        } catch (Exception e) {
            logger.error("Get user (email = {}) exception. Message: {}", email, e.getMessage());
            throw new DbOperationException("Get User exception");
        }
    }

    @Override
    public User update(User user) {
        int rowsAffect;
        try {
            LocalDateTime updatedDate = LocalDateTime.now();

            rowsAffect = template.update(
                    Queries.SQL_UPDATE,
                    user.getEmail(),
                    EncryptionUtil.encryptionPassword(user.getPassword()),
                    user.getSurname(),
                    user.getName(),
                    user.getPhoneNumber(),
                    user.isActive(),
                    updatedDate,
                    user.getId());

            user.setUpdatedDate(updatedDate);

        } catch (Exception e) {
            logger.error("Update user (id = {}) exception. Message: {}", user.getId(), e.getMessage());
            throw new DbOperationException("Update User exception");
        }

        if (rowsAffect < 1) throw getAndLogUserNotFoundException(user.getId());

        return user;
    }

    @Override
    public boolean delete(long id) {
        int rowsAffected;

        try {
            rowsAffected = template.update(Queries.SQL_SET_ACTIVE_STATUS_USER, false, id);
        } catch (Exception e) {
            logger.error("Delete user (id = {}) exception. Message: {}", id, e.getMessage());
            throw new DbOperationException("Delete User Exception");
        }

        if (rowsAffected < 1) throw getAndLogUserNotFoundException(id);
        else return true;
    }

    private NotFoundException getAndLogUserNotFoundException(Long id) {
        NotFoundException notFoundException = new NotFoundException("User not found");
        logger.error("Runtime exception. User not found (id = {}). Message: {}",
                id, notFoundException.getMessage());

        return notFoundException;
    }

    class Queries {
        static final String SQL_CREATE = "insert into Users (email, password, surname, name, phone_number, created_date, updated_date, active) values (?,?,?,?,?,?,?,?)";
        static final String SQL_GET_BY_ID = "select * from Users where id = ?";
        static final String SQL_GET_BY_EMAIL = "select * from Users where email = ?";
        static final String SQL_UPDATE = "update Users set email = ?, password = ?, surname = ?, name = ?, phone_number = ?, updated_date = ? where id = ?";
        static final String SQL_SET_ACTIVE_STATUS_USER = "UPDATE Users SET active = ? WHERE id = ?;";

    }

}
