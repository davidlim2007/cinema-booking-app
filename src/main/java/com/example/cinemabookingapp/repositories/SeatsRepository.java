package com.example.cinemabookingapp.repositories;

import com.example.cinemabookingapp.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seat, Long> {
}
