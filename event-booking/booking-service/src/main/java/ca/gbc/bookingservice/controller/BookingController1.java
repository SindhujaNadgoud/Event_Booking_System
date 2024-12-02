package ca.gbc.bookingservice.controller;

import ca.gbc.bookingservice.service.BookingConfirmationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka-producer")
public class BookingController1 {

    private final BookingConfirmationService bookingService;

    public BookingController1(BookingConfirmationService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/confirm/{bookingId}")
    public ResponseEntity<String> confirmBooking(@PathVariable String bookingId) {
        try {
            bookingService.confirmBooking(bookingId);
            return ResponseEntity.ok("Booking confirmed and event published for bookingId: " + bookingId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to confirm booking: " + e.getMessage());
        }
    }
}
