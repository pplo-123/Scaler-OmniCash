package com.cash.omni.repository;

import com.cash.omni.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends JpaRepository<Outlet,Long> {
}
