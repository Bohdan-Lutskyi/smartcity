package com.smartcity.DAO;

import com.smartcity.domain.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDAO {

    Transaction save(Transaction budget);

    Transaction findById(Integer id);

    boolean deleteById(Integer id);
}
