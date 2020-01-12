package com.cash.omni.repository;

import com.cash.omni.model.Customer;
import com.cash.omni.model.Person;
import com.cash.omni.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
