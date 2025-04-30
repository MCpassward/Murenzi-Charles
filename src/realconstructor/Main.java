package realconstructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REAL CONSTRUCTOR SYSTEM ===");
        System.out.println("1. Material Delivery");
        System.out.println("2. Material Usage");
        System.out.println("3. Cost Estimation");
        System.out.print("Select operation (1-3): ");

        int choice;
        try {
            choice = scanner.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Error: Please enter 1, 2, or 3");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a number.");
            return;
        }
        scanner.nextLine();

        System.out.print("Enter Contractor ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Error: Contractor ID cannot be empty");
            return;
        }

        System.out.print("Enter Contractor Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Contractor Name cannot be empty");
            return;
        }

        System.out.print("Enter Material Quantity (tons): ");
        double quantity;
        try {
            quantity = scanner.nextDouble();
            if (quantity <= 0) {
                System.out.println("Error: Quantity must be positive");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid quantity. Please enter a number.");
            return;
        }

        switch (choice) {
            case 1:
                MaterialDelivery delivery = new MaterialDelivery(id, name, quantity);
                delivery.receiveMaterial();
                break;
            case 2:
                System.out.print("Enter Quantity to Use (tons): ");
                double useQty;
                try {
                    useQty = scanner.nextDouble();
                    if (useQty <= 0) {
                        System.out.println("Error: Usage quantity must be positive");
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Invalid quantity. Please enter a number.");
                    return;
                }
                MaterialUsage usage = new MaterialUsage(id, name, quantity, useQty);
                usage.useMaterial();
                break;
            case 3:
                CostEstimation cost = new CostEstimation(id, name, quantity);
                cost.estimateCost();
                break;
        }

        scanner.close();
    }
}