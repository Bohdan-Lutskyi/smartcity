package com.smartcity.dao;

import com.smartcity.domain.Budget;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetDaoImpl implements BudgetDao {

    public Budget create(Budget budget) {
        return null;
    }

    public Budget get(long id) {
        return null;
    }

    public Budget update(Budget budget) {
        return null;
    }

    public boolean delete(long id) {
        return false;
    }

    private interface Queries{
        String SQL_CREATE = "insert into Roles(value) values(?)";
        String SQL_GET_BY_ID = "select * from Roles where id = ?";
        String SQL_UPDATE = "update Roles set id = ?, name = ?, updated_date = ?";
        String SQL_DELETE = "delete from Roles where id = ?";
    }
}
