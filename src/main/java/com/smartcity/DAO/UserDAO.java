package com.smartcity.DAO;

import com.smartcity.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    User create(User budget);

    User get(long id);

    User update(User budget);

    boolean deleteById(long id);
}
