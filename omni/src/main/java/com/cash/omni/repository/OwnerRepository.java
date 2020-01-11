package com.cash.omni.repository;

import com.cash.omni.model.OutletOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OutletOwner,Long> {
}
