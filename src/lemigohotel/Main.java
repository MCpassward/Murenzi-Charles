package lemigohotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LEMIGO HOTEL MANAGEMENT ===");
        System.out.println("1. Room Booking");
        System.out.println("2. Guest Checkout");
        System.out.println("3. Generate Bill");
        System.out.print("Select operation (1-3): ");

        int choice = getValidChoice(scanner, 1, 3);
        if (choice == -1) return;

        System.out.print("Enter Guest ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Error: Guest ID required");
            return;
        }

        System.out.print("Enter Guest Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Guest name required");
            return;
        }

        System.out.print("Enter Room Type (STANDARD/DELUXE/SUITE): ");
        String type = scanner.nextLine().trim().toUpperCase();

        int days = 0;
        String status = "";

        if (choice != 2) { // Booking or Bill
            System.out.print("Enter Stay Duration (1-30 days): ");
            days = getValidInt(scanner, 1, 30);
            if (days == -1) return;
        }

        if (choice != 3) { // Booking or Checkout
            System.out.print("Enter Room Status (AVAILABLE/OCCUPIED): ");
            status = scanner.nextLine().trim().toUpperCase();
            if (!status.equals("AVAILABLE") && !status.equals("OCCUPIED")) {
                System.out.println("Error: Invalid status");
                return;
            }
        }

        switch (choice) {
            case 1:
                RoomBooking booking = new RoomBooking(id, name, type, days, status);
                booking.bookRoom();
                break;
            case 2:
                GuestCheckout checkout = new GuestCheckout(id, name, type, 0, status);
                checkout.checkoutGuest();
                break;
            case 3:
                Billing bill = new Billing(id, name, type, days, "OCCUPIED");
                bill.generateBill();
                break;
        }

        scanner.close();
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < min || choice > max) {
                System.out.printf("Error: Please enter between %d and %d%n", min, max);
                return -1;
            }
            return choice;
        } catch (Exception e) {
            System.out.println("Error: Invalid input");
            return -1;
        }
    }

    private static int getValidInt(Scanner scanner, int min, int max) {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();
            if (value < min || value > max) {
                System.out.printf("Error: Value must be %d-%d%n", min, max);
                return -1;
            }
            return value;
        } catch (Exception e) {
            System.out.println("Error: Invalid number");
            return -1;
        }
    }
}