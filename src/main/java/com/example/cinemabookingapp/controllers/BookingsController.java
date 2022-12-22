package com.example.cinemabookingapp.controllers;

import com.example.cinemabookingapp.repositories.BookingsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cinemabookingapp.models.Booking;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingsController {
    @Autowired
    private BookingsRepository bookingsRepository;

    @GetMapping
    public List<Booking> getAll() {
        return bookingsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Booking getBooking(@PathVariable Long booking_id) {
        return bookingsRepository.getReferenceById(booking_id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Booking updateBooking(@PathVariable Long booking_id, @RequestBody Booking booking) {
        Booking existingBooking = bookingsRepository.getReferenceById(booking_id);
        BeanUtils.copyProperties(booking, existingBooking, "booking_id");
        return bookingsRepository.saveAndFlush(existingBooking);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    public void deleteBooking(@PathVariable Long booking_id) {
        bookingsRepository.deleteById(booking_id);
    }
}
