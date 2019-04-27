package com.smartcity.DAO;

import com.smartcity.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO {

    Role save(Role budget);

    Role findById(Integer id);

    boolean deleteById(Integer id);
}
