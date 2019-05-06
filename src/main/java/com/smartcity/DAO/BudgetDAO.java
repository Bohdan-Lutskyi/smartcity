//problem
package com.smartcity.DAO;

import com.smartcity.domain.Budget;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetDAO {

    Budget create(Budget budget);

    Budget get(long id);

    Budget update(Budget budget);

    boolean delete(long id);
}
