package lemigohotel;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        // Validate room type
        if (!roomType.equals("STANDARD") && !roomType.equals("DELUXE") && !roomType.equals("SUITE")) {
            System.out.println("Error: Invalid room type. Must be STANDARD, DELUXE, or SUITE.");
            return;
        }

        // Validate stay duration
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("Error: Stay duration must be 1-30 days.");
            return;
        }

        // Check room availability
        if (!roomStatus.equals("AVAILABLE")) {
            System.out.println("Error: Room is not available for booking.");
            return;
        }

        roomStatus = "OCCUPIED";
        System.out.println("\n=== BOOKING CONFIRMED ===");
        System.out.println("Guest: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Duration: " + stayDays + " days");
    }

    @Override
    public void checkoutGuest() {
        System.out.println("Error: Invalid operation for booking");
    }

    @Override
    public void generateBill() {
        System.out.println("Error: Invalid operation for booking");
    }
}