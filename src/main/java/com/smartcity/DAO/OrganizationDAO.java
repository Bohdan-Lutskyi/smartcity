package com.smartcity.DAO;

import com.smartcity.domain.Organization;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDAO {

    Organization create(Organization org);

    Organization get(long id);

    Organization update(Organization org);

    boolean delete(long id);
}
