package com.cash.omni.repository;

import com.cash.omni.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer,Long> {

    Customer findByPhoneNumber(String phoneNumber);
}
