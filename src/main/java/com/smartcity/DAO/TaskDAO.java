package com.smartcity.DAO;

import com.smartcity.domain.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO {

    Task save(Task budget);

    Task findById(Integer id);

    boolean deleteById(Integer id);
}
