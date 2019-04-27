package com.smartcity.DAO;

import com.smartcity.domain.Organization;

public interface OrganizationDAO {

    Organization save(Organization budget);

    Organization findById(Integer id);

    boolean deleteById(Integer id);
}
