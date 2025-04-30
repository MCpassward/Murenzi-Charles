package rwandapolice;

public abstract class TrafficRecord {
    protected String driverId;
    protected String driverName;
    protected String vehiclePlate;
    protected String violationType;
    protected double fineAmount;
    protected String paymentStatus;

    public TrafficRecord(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType.toUpperCase();
        this.paymentStatus = "UNPAID";
        this.fineAmount = 0;
    }

    public abstract void recordViolation();
    public abstract void assessFine();
    public abstract void processPayment();

    // Getters
    public String getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public String getVehiclePlate() { return vehiclePlate; }
    public String getViolationType() { return violationType; }
    public double getFineAmount() { return fineAmount; }
    public String getPaymentStatus() { return paymentStatus; }

    // Setters
    public void setFineAmount(double amount) { this.fineAmount = amount; }
    public void setPaymentStatus(String status) { this.paymentStatus = status; }
}