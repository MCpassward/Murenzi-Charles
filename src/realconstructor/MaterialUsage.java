package realconstructor;

public class MaterialUsage extends ConstructionMaterial {
    private double quantityToUse;

    public MaterialUsage(String contractorId, String contractorName,
                         double currentBalance, double quantityToUse) {
        super(contractorId, contractorName, currentBalance);
        this.materialBalance = currentBalance;
        this.quantityToUse = quantityToUse;
    }

    @Override
    public void receiveMaterial() {
        System.out.println("Error: Cannot receive materials in Usage operation");
    }

    @Override
    public void useMaterial() {
        if (quantityToUse <= 0) {
            System.out.println("Error: Usage quantity must be positive");
            return;
        }
        if (materialBalance - quantityToUse < 2) {
            System.out.printf("Error: Cannot go below 2 tons (Current: %.2f, Attempted use: %.2f)%n",
                    materialBalance, quantityToUse);
            return;
        }
        materialBalance -= quantityToUse;
        System.out.printf("Success: Used %.2f tons. Remaining: %.2f tons%n",
                quantityToUse, materialBalance);
    }

    @Override
    public void estimateCost() {
        System.out.println("Error: Cannot estimate costs in Usage operation");
    }
}