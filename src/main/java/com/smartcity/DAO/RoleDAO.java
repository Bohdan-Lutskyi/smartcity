package com.smartcity.DAO;

import com.smartcity.domain.Role;

public interface RoleDAO {

    Role save(Role budget);

    Role findById(Integer id);

    boolean deleteById(Integer id);
}
