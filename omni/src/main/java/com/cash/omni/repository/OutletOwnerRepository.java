package com.cash.omni.repository;

import com.cash.omni.model.OutletOwner;
import com.cash.omni.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletOwnerRepository extends JpaRepository<OutletOwner,Long> {


    @Query("select t.amount, t.transactionId, t.isSuccessful, t.creditedTo, t.debitedFrom, t.transactionDate from outlets o inner join transactions t on o.id = t.transaction_owner where o.owner = ?1")
    List<Transaction> findTransactionsByOutletOwner(Long id);
}
