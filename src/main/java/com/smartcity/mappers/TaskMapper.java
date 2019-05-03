package com.smartcity.mappers;

import com.smartcity.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper  implements RowMapper<Task> {

    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getLong("id"));
        task.setTitle(resultSet.getString("title"));
        task.setCreateDate(resultSet.getDate("createDate"));
        task.setUpdateDate(resultSet.getDate("updateDate"));
        task.setDescription(resultSet.getString("description"));
        task.setDeadlineDate(resultSet.getDate("deadlineDate"));
        task.setApprovedBudget(resultSet.getBigDecimal("approvedBudget"));
        return task;

    }
}
