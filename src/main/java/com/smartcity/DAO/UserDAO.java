package com.smartcity.DAO;

import com.smartcity.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    User save(User budget);

    User findById(Integer id);

    boolean deleteById(Integer id);
}
