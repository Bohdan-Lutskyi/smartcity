package com.smartcity.DAO;

import com.smartcity.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO {

    Optional<User> create(User user);

    Optional<User> get(long id);

    Optional<User> update(User user);

    boolean delete(long id);
}
