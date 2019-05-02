package com.smartcity.DAO;

import com.smartcity.domain.TaskStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusDAO {

    TaskStatus create(TaskStatus taskStatus);

    TaskStatus get(long id);

    TaskStatus update(TaskStatus taskStatus);

    boolean delete(long id);
}
