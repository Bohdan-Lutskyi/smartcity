package com.smartcity.DAO;

import com.smartcity.domain.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO {

    Task create(Task task);

    Task get(long id);

    Task update(Task task);

    boolean delete(long id);
}
