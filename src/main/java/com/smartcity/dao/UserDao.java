package com.smartcity.dao;

import com.smartcity.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao {

    Optional<User> create(User user);

    Optional<User> get(long id);

    Optional<User> update(User user);

    boolean delete(long id);
}
