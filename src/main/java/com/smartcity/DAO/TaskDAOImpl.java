package com.smartcity.dao;

import com.smartcity.dao.TaskDao;
import com.smartcity.domain.Task;
import com.smartcity.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;

public class TaskDaoImpl implements TaskDao {

    private JdbcTemplate template;

    @Autowired
    private void setDataSource(DataSource dataSource){this.template = new JdbcTemplate(dataSource);}

    public Task create(Task task) {
        try {
            template.update(Queries.SQL_CREATE, task.getId(), task.getTitle(),
                    CurrentDate.getCurrentDate(), CurrentDate.getCurrentDate(),
                    task.getDescription(), task.getDeadlineDate(), task.getBudget(),
                    task.getApprovedBudget(), task.getUserOrganizationId());
            return task;
        }catch (Exception e){
            return null;
        }
    }

    public Task get(long id) {
        return template.queryForObject(Queries.SQL_GET_BY_ID, new Object[]{id}, new TaskMapper());
    }

    public Task update(Task task) {
        try {
            this.template.update(Queries.SQL_UPDATE,task.getTitle(),CurrentDate.getCurrentDate(),
                    task.getDescription(),task.getDeadlineDate(),
                    task.getBudget(),task.getApprovedBudget(),task.getId());
            return task;
        }catch (Exception e){
            return null;
        }
    }

    public boolean delete(long id) {
        try {
            this.template.update(Queries.SQL_DELETE,id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private interface Queries{
        String SQL_CREATE = "insert into Task(id, title, createDate, updateDate, description, " +
                "deadlineDate, budget, approvedBudget, taskStatusId, " +
                "userOrganizationId) values(?,?,?,?,?,?,?,?,?,?)";
        String SQL_GET_BY_ID = "select * from Task where id = ?";
        String SQL_UPDATE = "update task set title = ?, updateDate = ?, description= ?, deadlineDate = ?, " +
                "budget = ?, approvedBudget = ?, taskStatus = ? where id = ?";
        String SQL_DELETE = "delete from Task where id = ?";

    }

    private static class CurrentDate{
        private static Date getCurrentDate() { return new Date(System.currentTimeMillis());}
    }

}
