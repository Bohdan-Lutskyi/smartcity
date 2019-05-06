package com.smartcity.dao;

import com.smartcity.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskDao {

    Optional<Task> create(Task task);

    Optional<Task> get(long id);

    Optional<Task> update(Task task);

    boolean delete(long id);
}
