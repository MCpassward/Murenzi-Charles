package rwandapolice;

import java.text.NumberFormat;
import java.util.Locale;

public class FinePayment extends TrafficRecord {
    public FinePayment(String driverId, String driverName, String vehiclePlate,
                       String violationType, double fineAmount) {
        super(driverId, driverName, vehiclePlate, violationType);
        this.fineAmount = fineAmount;
    }

    @Override
    public void recordViolation() {
        System.out.println("Error: Invalid operation for payment");
    }

    @Override
    public void assessFine() {
        System.out.println("Error: Invalid operation for payment");
    }

    @Override
    public void processPayment() {
        if (paymentStatus.equals("PAID")) {
            System.out.println("Error: Fine already paid");
            return;
        }

        if (fineAmount <= 0) {
            System.out.println("Error: Invalid fine amount");
            return;
        }

        paymentStatus = "PAID";
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        fmt.setMaximumFractionDigits(0);

        System.out.println("\n=== PAYMENT RECEIPT ===");
        System.out.println("Driver: " + driverName + " (" + driverId + ")");
        System.out.println("Vehicle: " + vehiclePlate);
        System.out.println("Violation: " + violationType);
        System.out.println("Amount Paid: " + fmt.format(fineAmount));
        System.out.println("Payment Status: " + paymentStatus);
    }
}