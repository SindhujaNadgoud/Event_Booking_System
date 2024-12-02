package ca.gbc.bookingservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingConfirmationService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String bookingTopic = "booking-events";



    public BookingConfirmationService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void confirmBooking(String bookingId) {
        // Simulate booking confirmation logic
        System.out.println("Booking confirmed: " + bookingId);

        // Create a booking event
        String bookingEvent = "{ \"bookingId\": \"" + bookingId + "\", \"status\": \"CONFIRMED\" }";

        // Publish to Kafka
        kafkaTemplate.send(bookingTopic, bookingId, bookingEvent);
        System.out.println("Published booking event to Kafka: " + bookingEvent);
    }
}
