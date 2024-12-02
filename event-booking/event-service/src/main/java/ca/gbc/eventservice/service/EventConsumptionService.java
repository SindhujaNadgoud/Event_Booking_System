package ca.gbc.eventservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class EventConsumptionService {

        public void registerEvent(String bookingId) {
            // Simulate event registration logic
            System.out.println("Registering event for confirmed bookingId: " + bookingId);
            // Add your actual logic here, e.g., save to database or call another service
        }

        @KafkaListener(topics = "${spring.kafka.topic.booking}", groupId = "${spring.kafka.consumer.group-id}")
        public void consumeBookingEvent(String message) {
            try {
                // Log the consumed event
                System.out.println("Consumed booking event: " + message);

                // Parse the message (assume it's JSON)
                // Example message: {"bookingId": "12345", "status": "CONFIRMED"}
                String bookingId = parseBookingId(message);

                // Process only confirmed bookings
                if (isConfirmed(message)) {
                    registerEvent(bookingId);
                } else {
                    System.out.println("Ignored non-confirmed booking event: " + message);
                }
            } catch (Exception e) {
                System.err.println("Failed to process booking event: " + message + ". Error: " + e.getMessage());
            }
        }

        private String parseBookingId(String message) {
            // Parse JSON to extract bookingId (use a library like Jackson/Gson in real implementation)
            return message.replaceAll(".*\"bookingId\":\"(.*?)\".*", "$1");
        }

        private boolean isConfirmed(String message) {
            // Check if the status is "CONFIRMED" (use a library like Jackson/Gson in real implementation)
            return message.contains("\"status\":\"CONFIRMED\"");
        }
    }


