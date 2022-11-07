package com.arka99.AB_Bank_Backend.repositories;

import com.arka99.AB_Bank_Backend.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions,Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerID);
}
