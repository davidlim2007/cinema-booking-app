package com.example.cinemabookingapp.repositories;

import com.example.cinemabookingapp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
}
