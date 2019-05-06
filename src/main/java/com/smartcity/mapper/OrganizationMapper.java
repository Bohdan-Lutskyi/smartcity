package com.smartcity.mapper;

import com.smartcity.domain.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationMapper implements RowMapper<Organization> {

    public Organization mapRow(ResultSet resultSet, int i) throws SQLException {
        Organization organization = new Organization();

        organization.setId(resultSet.getLong("id"));
        organization.setName(resultSet.getString("name"));
        organization.setAddress(resultSet.getString("address"));
        organization.setCreatedDate(resultSet.getDate("created_date"));
        organization.setUpdatedDate(resultSet.getDate("updated_date"));

        return organization;
    }
}
