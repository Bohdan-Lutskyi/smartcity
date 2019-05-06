package com.smartcity.mapper;

import com.smartcity.domain.Budget;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BudgetMapper implements RowMapper<Budget> {

    public Budget mapRow(ResultSet resultSet, int i) throws SQLException {
        Budget budget = new Budget();

        budget.setValue(resultSet.getBigDecimal("budget"));
        return budget;
    }
}
