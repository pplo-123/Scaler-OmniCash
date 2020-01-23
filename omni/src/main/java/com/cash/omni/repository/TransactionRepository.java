package com.cash.omni.repository;

import com.cash.omni.model.Customer;
import com.cash.omni.model.Person;
import com.cash.omni.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select t.* from customers c inner join transactions t on c.id = t.customer_id where c.id = ?1", nativeQuery = true)
    List<Transaction> findAllByCustomerId(long id);
}