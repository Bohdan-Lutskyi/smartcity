package com.smartcity.DAO;

import com.smartcity.domain.User;

public interface UserDAO {

    User save(User budget);

    User findById(Integer id);

    boolean deleteById(Integer id);
}
