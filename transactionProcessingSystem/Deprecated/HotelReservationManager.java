package transactionProcessingSystem.Deprecated;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationManager {
    private List<HotelReservation> reservations;

    public HotelReservationManager() {
        reservations = new ArrayList<>();
    }

    public void addReservation(HotelReservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(HotelReservation reservation) {
        reservations.remove(reservation);
    }

    public List<HotelReservation> getAllReservations() {
        return reservations;
    }

    public HotelReservation findReservationByRoomNumber(int roomNumber) {
        for (HotelReservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber) {
                return reservation;
            }
        }
        return null;
    }
}
