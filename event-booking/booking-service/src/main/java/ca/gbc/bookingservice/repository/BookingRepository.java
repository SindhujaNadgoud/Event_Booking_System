package main.java.ca.gbc.bookingservice.repository;

import main.java.ca.gbc.bookingservice.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByRoomId(String roomId);
    List<Booking> findByUserId(String userId);
}