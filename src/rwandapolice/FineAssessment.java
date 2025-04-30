package rwandapolice;

import java.text.NumberFormat;
import java.util.Locale;

public class FineAssessment extends TrafficRecord {
    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType) {
        super(driverId, driverName, vehiclePlate, violationType);
    }

    @Override
    public void recordViolation() {
        System.out.println("Error: Invalid operation for fine assessment");
    }

    @Override
    public void assessFine() {
        switch (violationType) {
            case "SPEEDING": fineAmount = 50000; break;
            case "RED_LIGHT": fineAmount = 80000; break;
            case "NO_HELMET": fineAmount = 30000; break;
            case "DUI": fineAmount = 150000; break;
            default:
                System.out.println("Error: Unrecognized violation type");
                return;
        }

        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        fmt.setMaximumFractionDigits(0);

        System.out.println("\n=== FINE ASSESSMENT ===");
        System.out.println("Driver: " + driverName);
        System.out.println("Vehicle: " + vehiclePlate);
        System.out.println("Violation: " + violationType);
        System.out.println("Fine Amount: " + fmt.format(fineAmount));
    }

    @Override
    public void processPayment() {
        System.out.println("Error: Invalid operation for fine assessment");
    }
}