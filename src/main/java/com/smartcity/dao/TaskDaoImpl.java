package com.smartcity.dao;

import com.smartcity.domain.Task;
import com.smartcity.exceptions.DbOperationException;
import com.smartcity.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class TaskDaoImpl implements TaskDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<Task> create(Task task) {
        try {
            jdbcTemplate.update(Queries.SQL_CREATE,
                    task.getTitle(), task.getDescription(),
                    task.getDeadlineDate(), task.getTaskStatus(),
                    task.getBudget(), task.getApprovedBudget(),
                    LocalDate.now(), LocalDate.now(),
                    task.getUserOrganizationId());

            return Optional.of(task);
        } catch (Exception e){
            e.printStackTrace();
            throw new DbOperationException(e.getMessage());
        }
    }

    public Optional<Task> get(long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    Queries.SQL_GET_BY_ID,
                    TaskMapper.getInstance(),
                    id));
        } catch (Exception e) {
            throw new DbOperationException("Get Task exception");
        }
    }

    public Optional<Task> update(Task task) {
        try {
            this.jdbcTemplate.update(Queries.SQL_UPDATE,
                    task.getTitle(),                  task.getDescription(),
                    task.getDeadlineDate(),          task.getTaskStatus(),
                    task.getBudget(),                 task.getApprovedBudget(),
                    task.getCreatedDate(),           CurrentDate.getCurDate(),
                    task.getUserOrganizationId(), task.getId());
            return Optional.of(task);
        }catch (Exception e){
            e.printStackTrace();
            throw new DbOperationException(e.getMessage());
        }
    }

    public boolean delete(long id) {
        try {
            return this.jdbcTemplate.update(Queries.SQL_DELETE,id)>0;
        }catch (Exception e){
            e.printStackTrace();
            throw new DbOperationException(e.getMessage());
        }
    }

    private interface Queries{
        String SQL_CREATE = "Insert into Tasks(title, description, " +
                "deadline_date, task_status,  budget,  " +
                "approved_budget, created_date, updated_date," +
                "users_organizations_id) values (?,?,?,?,?,?,?,?,?)";

        String SQL_GET_BY_ID = "select * from Tasks where id = ?";

        String SQL_UPDATE = "Update Tasks set title = ? , description = ?, " +
                "deadline_date = ?, task_status = ?, budget = ?, " +
                "approved_budget = ?, created_date = ?, " +
                "updated_date = ?,  users_organizations_id = ? where id = ?";

        String SQL_DELETE = "Delete from Tasks where id = ?";
    }

    private static class CurrentDate {
        private static LocalDate getCurDate() {
            return LocalDate.now();
        }
    }
}

