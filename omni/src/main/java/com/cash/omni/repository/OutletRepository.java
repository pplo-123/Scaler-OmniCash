package com.cash.omni.repository;

import com.cash.omni.model.Feedback;
import com.cash.omni.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletRepository extends JpaRepository<Outlet,Long> {

    @Query("select f.content, f.review, f.customer, f.Date from outlets o inner join feedbacks f on o.id = f.outlet where o.id = ?1")
    public List<Feedback> findFeedbacks(Long id);
}
