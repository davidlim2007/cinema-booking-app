package com.example.cinemabookingapp.repositories;

import com.example.cinemabookingapp.models.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatsRepository extends JpaRepository<Seat, Long> {
    @Query("select s from seat s where s.hall_no = :hall_no")
    Page<Seat> getSeatsWithHallNo(@Param("hall_no") Long hall_no, Pageable pageable);
}
