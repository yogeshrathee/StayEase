package com.example.stayease.controller;

import com.example.stayease.model.Booking;
import com.example.stayease.model.User;
import com.example.stayease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/hotels/{hotelId}/book")
    public ResponseEntity<Booking> bookRoom(@PathVariable Long hotelId, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(bookingService.bookRoom(hotelId, user.getId()), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
