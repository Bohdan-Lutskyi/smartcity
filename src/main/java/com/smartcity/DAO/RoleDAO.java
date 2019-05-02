package com.smartcity.DAO;

import com.smartcity.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO {

    Role create(Role role);

    Role get(long id);

    Role update(Role role);

    boolean delete(long id);
}
