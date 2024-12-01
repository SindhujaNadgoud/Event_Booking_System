package main.java.ca.gbc.bookingservice.service;
import main.java.ca.gbc.bookingservice.dto.BookingRequest;
import main.java.ca.gbc.bookingservice.dto.BookingResponse;
import main.java.ca.gbc.bookingservice.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    BookingResponse createBooking(BookingRequest bookingRequest);
    Optional<Booking> getBookingById(String id);
    List<BookingResponse> getAllBookings();
    String updateBooking(String id, BookingRequest bookingRequest);
    void deleteBooking(String id);
}