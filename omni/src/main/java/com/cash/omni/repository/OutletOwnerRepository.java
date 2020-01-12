package com.cash.omni.repository;

import com.cash.omni.model.OutletOwner;
import com.cash.omni.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletOwnerRepository extends JpaRepository<OutletOwner,Long> {


    @Query(value = "select t from Outlet o inner join Transaction t on o.id = t.outlet where o.outletOwner = ?1", nativeQuery = true)
    List<Transaction> findTransactionByOutletOwner(Long id);
}