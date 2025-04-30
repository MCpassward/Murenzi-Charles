package lemigohotel;

import java.text.NumberFormat;
import java.util.Locale;

public class Billing extends HotelService {
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        System.out.println("Error: Invalid operation for billing");
    }

    @Override
    public void checkoutGuest() {
        System.out.println("Error: Invalid operation for billing");
    }

    @Override
    public void generateBill() {
        int rate;
        switch (roomType) {
            case "STANDARD": rate = 50000; break;
            case "DELUXE": rate = 80000; break;
            case "SUITE": rate = 120000; break;
            default:
                System.out.println("Error: Invalid room type for billing");
                return;
        }

        if (stayDays < 1) {
            System.out.println("Error: Invalid stay duration");
            return;
        }

        int total = stayDays * rate;
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        fmt.setMaximumFractionDigits(0);

        System.out.println("\n=== GUEST BILL ===");
        System.out.println("Guest: " + guestName + " (" + guestId + ")");
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " days");
        System.out.println("Total Amount Due: " + fmt.format(total));
    }
}