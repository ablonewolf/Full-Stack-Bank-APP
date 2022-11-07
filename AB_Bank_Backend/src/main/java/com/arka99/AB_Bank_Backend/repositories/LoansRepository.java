package com.arka99.AB_Bank_Backend.repositories;

import com.arka99.AB_Bank_Backend.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends CrudRepository<Loans,Long> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerID);
}
