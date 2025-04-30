package rwandapolice;

public class ViolationEntry extends TrafficRecord {
    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType) {
        super(driverId, driverName, vehiclePlate, violationType);
    }

    @Override
    public void recordViolation() {
        // Validate driver ID (16 digits)
        if (!driverId.matches("\\d{16}")) {
            System.out.println("Error: Driver ID must be 16 digits");
            return;
        }

        // Validate plate format (RAA123A)
        if (!vehiclePlate.matches("[A-Z]{2,3}\\d{3}[A-Z]")) {
            System.out.println("Error: Plate must be in format like RAA123A");
            return;
        }

        // Validate violation type
        String[] validTypes = {"SPEEDING", "RED_LIGHT", "NO_HELMET", "DUI"};
        boolean valid = false;
        for (String type : validTypes) {
            if (violationType.equals(type)) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            System.out.println("Error: Invalid violation type");
            return;
        }

        System.out.println("\n=== VIOLATION RECORDED ===");
        System.out.println("Driver: " + driverName + " (" + driverId + ")");
        System.out.println("Vehicle: " + vehiclePlate);
        System.out.println("Violation: " + violationType);
        System.out.println("Status: " + paymentStatus);
    }

    @Override
    public void assessFine() {
        System.out.println("Error: Invalid operation for violation entry");
    }

    @Override
    public void processPayment() {
        System.out.println("Error: Invalid operation for violation entry");
    }
}