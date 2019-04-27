package com.smartcity.DAO;

import com.smartcity.domain.Budget;

public interface BudgetDAO {

    Budget save(Budget budget);

    Budget findById(Integer id);

    boolean deleteById(Integer id);
}
