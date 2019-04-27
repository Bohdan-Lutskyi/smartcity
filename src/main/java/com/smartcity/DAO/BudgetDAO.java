package com.smartcity.DAO;

import com.smartcity.domain.Budget;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetDAO {

    Budget save(Budget budget);

    Budget findById(Integer id);

    boolean deleteById(Integer id);
}
