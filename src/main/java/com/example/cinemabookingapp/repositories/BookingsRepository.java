package com.example.cinemabookingapp.repositories;

import com.example.cinemabookingapp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
    List<Booking> getBookingsWithMovie(@Param("movie_id") Long movie_id);
}
