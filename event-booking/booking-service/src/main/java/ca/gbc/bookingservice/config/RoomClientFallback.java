package ca.gbc.bookingservice.config;

import ca.gbc.bookingservice.client.RoomClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomClientFallback implements FallbackFactory<RoomClient> {
//
//    @Override
//    public boolean isAvailable(String roomId) {
//        // Return a default response when the service is unavailable
//        return false; // Indicate the room is unavailable by default
//    }
//
//    @Override
//    public void updateAvailability(String roomId, Boolean availability) {
//        // Provide a no-op or log the failure
//        System.out.println("Fallback: Unable to update room availability for roomId " + roomId);
//    }

    @Override
    public RoomClient create(Throwable cause) {
        return null;
    }
}
