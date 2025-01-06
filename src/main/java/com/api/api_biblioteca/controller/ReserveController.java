package com.api.api_biblioteca.controller;

import com.api.api_biblioteca.domain.Reservation;
import com.api.api_biblioteca.domain.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get reservations by user ID")
    @ApiResponse(responseCode = "200", description = "List of reservations for the specified user")
    public ResponseEntity<List<Reservation>> findByUserId(
            @Parameter(description = "The ID of the user", required = true, example = "1")
            @PathVariable("userId") int userId) {
        return new ResponseEntity<>(reserveService.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    @Operation(summary = "Get reservations by book ID")
    @ApiResponse(responseCode = "200", description = "List of reservations for the specified book")
    public ResponseEntity<List<Reservation>> findByBookId(
            @Parameter(description = "The ID of the book", required = true, example = "101")
            @PathVariable("bookId") int bookId) {
        return new ResponseEntity<>(reserveService.findByBookId(bookId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/book/{bookId}")
    @Operation(summary = "Get a reservation by user ID and book ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation found"),
            @ApiResponse(responseCode = "404", description = "Reservation not found")
    })
    public ResponseEntity<Reservation> findByUserIdAndBookId(
            @Parameter(description = "The ID of the user", required = true, example = "1")
            @PathVariable("userId") int userId,
            @Parameter(description = "The ID of the book", required = true, example = "101")
            @PathVariable("bookId") int bookId) {
        return reserveService.findByUserIdAndBookId(userId, bookId)
                .map(reservation -> new ResponseEntity<>(reservation, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/after/{date}")
    @Operation(summary = "Get reservations after a specific date")
    @ApiResponse(responseCode = "200", description = "List of reservations made after the specified date")
    public ResponseEntity<List<Reservation>> findByReservationDateAfter(
            @Parameter(description = "The date after which reservations are retrieved", required = true, example = "2023-01-01T00:00:00")
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return new ResponseEntity<>(reserveService.findByReservationDateAfter(date), HttpStatus.OK);
    }

    @GetMapping("/before/{date}")
    @Operation(summary = "Get reservations expiring before a specific date")
    @ApiResponse(responseCode = "200", description = "List of reservations expiring before the specified date")
    public ResponseEntity<List<Reservation>> findByExpirationDateBefore(
            @Parameter(description = "The date before which reservations are retrieved", required = true, example = "2023-12-31T23:59:59")
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return new ResponseEntity<>(reserveService.findByExpirationDateBefore(date), HttpStatus.OK);
    }

    @GetMapping("/count/after/{date}")
    @Operation(summary = "Count reservations expiring after a specific date")
    @ApiResponse(responseCode = "200", description = "The count of reservations expiring after the specified date")
    public ResponseEntity<Long> countByExpirationDateAfter(
            @Parameter(description = "The date after which reservations are counted", required = true, example = "2023-01-01T00:00:00")
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        long count = reserveService.countByExpirationDateAfter(date);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/exists/{reservationId}/before/{date}")
    @Operation(summary = "Check if a reservation exists and expires before a specific date")
    @ApiResponse(responseCode = "200", description = "Boolean indicating whether the reservation exists and expires before the date")
    public ResponseEntity<Boolean> existsByIdAndExpirationDateBefore(
            @Parameter(description = "The ID of the reservation", required = true, example = "1")
            @PathVariable("reservationId") int reservationId,
            @Parameter(description = "The date to check against expiration", required = true, example = "2023-12-31T23:59:59")
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        boolean exists = reserveService.existsByIdAndExpirationDateBefore(reservationId, date);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new reservation")
    @ApiResponse(responseCode = "201", description = "Reservation successfully created")
    public ResponseEntity<Reservation> save(
            @Parameter(description = "The reservation object to save")
            @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reserveService.save(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{userId}/{bookId}")
    @Operation(summary = "Delete a reservation by user ID and book ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Reservation not found")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "The ID of the user", required = true, example = "1")
            @PathVariable("userId") int userId,
            @Parameter(description = "The ID of the book", required = true, example = "101")
            @PathVariable("bookId") int bookId) {
        if (reserveService.delete(userId, bookId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

