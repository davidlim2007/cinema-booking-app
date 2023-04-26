package com.example.cinemabookingapp.controllers;

import com.example.cinemabookingapp.repositories.SeatsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cinemabookingapp.models.Seat;
import java.util.List;

@RestController
@RequestMapping("/api/v1/seats")
public class SeatsController {
    @Autowired
    private SeatsRepository seatsRepository;

    @GetMapping
    public List<Seat> getAll() {
        return seatsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{seat_id}")
    public Seat getSeat(@PathVariable Long seat_id) {
        return seatsRepository.getReferenceById(seat_id);
    }

    @PostMapping
    public Seat addSeat(@RequestBody final Seat seat) {
        return seatsRepository.saveAndFlush(seat);
    }

    @RequestMapping(value = "{seat_id}", method = RequestMethod.PUT)
    public Seat updateSeat(@PathVariable Long seat_id, @RequestBody Seat seat) {
        Seat existingSeat = seatsRepository.getReferenceById(seat_id);
        BeanUtils.copyProperties(seat, existingSeat, "seat_id");
        return seatsRepository.saveAndFlush(existingSeat);
    }

    @DeleteMapping("{seat_id}")
    public void deleteSeat(@PathVariable Long seat_id) {
        seatsRepository.deleteById(seat_id);
    }

    @GetMapping
    @RequestMapping("hall={hall_no}")
    public ResponseEntity<String> getSeatsWithHallNo(@PathVariable Long hall_no) {
        Page<Seat> seatsPage = seatsRepository.getSeatsWithHallNo(hall_no,
                PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, "seat_id")));

        if (seatsPage.getTotalElements() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Paging successful.");
    }
}
