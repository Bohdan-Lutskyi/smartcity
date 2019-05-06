package com.smartcity.mapper;

import com.smartcity.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper  implements RowMapper<Task> {
    private static TaskMapper instance = new TaskMapper();
    public static TaskMapper getInstance(){return instance;}

    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getLong("id"));
        task.setTitle(resultSet.getString("title"));
        task.setDescription(resultSet.getString("description"));
        task.setDeadlineDate(resultSet.getDate("deadline_date").toLocalDate());
        task.setTaskStatus(resultSet.getString("task_status"));
        task.setBudget(resultSet.getLong("budget"));
        task.setApprovedBudget(resultSet.getLong("approved_budget"));
        task.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
        task.setUpdatedDate(resultSet.getDate("updated_date").toLocalDate());
        task.setUserOrganizationId(resultSet.getLong("users_organizations_id"));
        return task;

    }
}
