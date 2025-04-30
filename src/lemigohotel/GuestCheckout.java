package lemigohotel;

public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        System.out.println("Error: Invalid operation for checkout");
    }

    @Override
    public void checkoutGuest() {
        if (!roomStatus.equals("OCCUPIED")) {
            System.out.println("Error: No guest to checkout - room is available");
            return;
        }

        roomStatus = "AVAILABLE";
        System.out.println("\n=== CHECKOUT COMPLETE ===");
        System.out.println("Guest: " + guestName + " has checked out");
        System.out.println("Room Type: " + roomType + " is now available");
    }

    @Override
    public void generateBill() {
        System.out.println("Error: Invalid operation for checkout");
    }
}