package com.smartcity.DAO;

import com.smartcity.domain.Organization;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDAO {

    Organization save(Organization budget);

    Organization findById(Integer id);

    boolean deleteById(Integer id);
}
