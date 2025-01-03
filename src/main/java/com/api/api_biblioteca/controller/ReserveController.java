package com.api.api_biblioteca.controller;

import com.api.api_biblioteca.domain.Reservation;
import com.api.api_biblioteca.domain.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Optional;
@RestController
@RequestMapping("/reservations")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> findByUserId(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(reserveService.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Reservation>> findByBookId(@PathVariable("bookId") int bookId) {
        return new ResponseEntity<>(reserveService.findByBookId(bookId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/book/{bookId}")
    public ResponseEntity<Reservation> findByUserIdAndBookId(@PathVariable("userId") int userId,
                                                             @PathVariable("bookId") int bookId) {
        return reserveService.findByUserIdAndBookId(userId, bookId)
                .map(reservation -> new ResponseEntity<>(reservation, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/after/{date}")
    public ResponseEntity<List<Reservation>> findByReservationDateAfter(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return new ResponseEntity<>(reserveService.findByReservationDateAfter(date), HttpStatus.OK);
    }

    @GetMapping("/before/{date}")
    public ResponseEntity<List<Reservation>> findByExpirationDateBefore(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return new ResponseEntity<>(reserveService.findByExpirationDateBefore(date), HttpStatus.OK);
    }

    @GetMapping("/count/after/{date}")
    public ResponseEntity<Long> countByExpirationDateAfter(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        long count = reserveService.countByExpirationDateAfter(date);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/exists/{reservationId}/before/{date}")
    public ResponseEntity<Boolean> existsByIdAndExpirationDateBefore(@PathVariable("reservationId") int reservationId,
                                                                     @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        boolean exists = reserveService.existsByIdAndExpirationDateBefore(reservationId, date);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reserveService.save(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{userId}/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") int userId, @PathVariable("bookId") int bookId) {
        if (reserveService.delete(userId, bookId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
