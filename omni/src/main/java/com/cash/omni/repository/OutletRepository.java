package com.cash.omni.repository;

import com.cash.omni.model.Feedback;
import com.cash.omni.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Long>
{
    @Query(value = "select f from Outlet o inner join Feedback f where o.id = f.outlet and o.id = ?1", nativeQuery = true)
    public List<Feedback> findFeedbacks(Long id);
}