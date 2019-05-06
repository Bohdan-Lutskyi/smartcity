package com.smartcity.dao;

import com.smartcity.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskDao {

    Optional create(Task task);

    Optional get(long id);

    Optional update(Task task);

    boolean delete(long id);
}
