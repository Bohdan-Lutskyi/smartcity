package com.smartcity.dao;

import com.smartcity.domain.Task;
import com.smartcity.exception.DBOperationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskDaoImplTest {
    private TaskDaoImpl taskDao;
    private Task task;
    private DriverManagerDataSource dataSource;

    @BeforeEach
    public void setup() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.99.100:3306/smartcity?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        taskDao = new TaskDaoImpl(dataSource);

        task = new Task(
                1L,
                "Title",
                "Description",
                LocalDate.now(),
                "Task Status",
                1000L,
                1000L,
                LocalDate.now(),
                LocalDate.now(),
                1L);
    }

    @Test
    public void creatingTask() {
        assertEquals(task, taskDao.create(task).get());
    }


    @Test
    public void gettingTaskByID() {
        taskDao.create(task);
        Task resultTask = taskDao.get(1).get();

        assertThat(task).isEqualToIgnoringGivenFields(resultTask,
                "deadlineDate", "createdDate", "updatedDate");
    }

    @Test
    public void updatingTaskWhereID_1() {
        // Creating task
        taskDao.create(task);

        // Creating updated task
        Task updatedTask = new Task(
                1L,
                "Title2",
                "Description2",
                LocalDate.now(),
                "Task Status2",
                200L,
                2000L,
                LocalDate.now(),
                LocalDate.now(),
                1L);

        // Updating
        taskDao.update(updatedTask);

        // Getting task from db
        Task resultTask = taskDao.get(1).get();

        // Checking if both are equal
        assertThat(updatedTask).isEqualToIgnoringGivenFields(resultTask,
                "deadlineDate", "createdDate", "updatedDate");
    }

    @Test
    public void deletingUserWhereID_1_ThrowsException() {
        // Creating task
        taskDao.create(task);

        // Deleting 1-st task from db
        taskDao.delete(1);

        // Exception, because there are no task with id 1
        assertThrows(DBOperationException.class, () -> taskDao.get(1).get());
    }

    @Test
    public void deletingTask() {
        // Creating task
        taskDao.create(task);

        // Deleting 1-st task from db
        assertTrue(taskDao.delete(1));
    }

    @Test
    public void deletingNotExistingTask() {
        // Deleting not existing task from db
        assertFalse(taskDao.delete(1));
    }

    @AfterEach
    void tearDown() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("DELETE FROM Tasks");
        template.update("ALTER TABLE Tasks AUTO_INCREMENT = 1");
    }
}