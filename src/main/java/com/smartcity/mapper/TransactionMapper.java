package com.smartcity.mapper;

import com.smartcity.domain.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {

    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        Transaction transaction = new Transaction();

        transaction.setId(resultSet.getLong("id"));
        transaction.setTaskId(resultSet.getLong("task_id"));
        transaction.setCurrentBudget(resultSet.getBigDecimal("current_budget"));
        transaction.setCreatedDate(resultSet.getDate("updated_date"));
        transaction.setUpdatedDate(resultSet.getDate("created_date"));

        return transaction;
    }
}
