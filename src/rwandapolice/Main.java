package rwandapolice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== RWANDA POLICE TRAFFIC SYSTEM ===");
        System.out.println("1. Record Violation");
        System.out.println("2. Assess Fine");
        System.out.println("3. Process Payment");
        System.out.print("Select operation (1-3): ");

        int choice = getValidChoice(scanner, 1, 3);
        if (choice == -1) return;

        System.out.print("Enter Driver ID (16 digits): ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter Driver Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name required");
            return;
        }

        System.out.print("Enter Vehicle Plate (e.g., RAA123A): ");
        String plate = scanner.nextLine().trim();

        System.out.print("Enter Violation Type (SPEEDING/RED_LIGHT/NO_HELMET/DUI): ");
        String violation = scanner.nextLine().trim().toUpperCase();

        switch (choice) {
            case 1:
                ViolationEntry entry = new ViolationEntry(id, name, plate, violation);
                entry.recordViolation();
                break;
            case 2:
                FineAssessment assessment = new FineAssessment(id, name, plate, violation);
                assessment.assessFine();
                break;
            case 3:
                System.out.print("Enter Fine Amount: ");
                double amount;
                try {
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount <= 0) {
                        System.out.println("Error: Amount must be positive");
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Invalid amount");
                    return;
                }
                FinePayment payment = new FinePayment(id, name, plate, violation, amount);
                payment.processPayment();
                break;
        }

        scanner.close();
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < min || choice > max) {
                System.out.printf("Error: Choose between %d and %d%n", min, max);
                return -1;
            }
            return choice;
        } catch (Exception e) {
            System.out.println("Error: Invalid choice");
            return -1;
        }
    }
}