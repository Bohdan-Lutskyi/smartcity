package com.smartcity.DAO;

import com.smartcity.domain.TaskStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusDAO {

    TaskStatus save(TaskStatus budget);

    TaskStatus findById(Integer id);

    boolean deleteById(Integer id);
}
