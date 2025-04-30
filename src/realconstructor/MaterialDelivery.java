package realconstructor;

public class MaterialDelivery extends ConstructionMaterial {
    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity) {
        super(contractorId, contractorName, materialQuantity);
    }

    @Override
    public void receiveMaterial() {
        if (materialQuantity < 1 || materialQuantity > 10) {
            System.out.println("Error: Delivery quantity must be between 1-10 tons.");
            return;
        }
        materialBalance += materialQuantity;
        System.out.printf("Success: %.2f tons delivered. New balance: %.2f tons%n",
                materialQuantity, materialBalance);
    }

    @Override
    public void useMaterial() {
        System.out.println("Error: Cannot use materials in Delivery operation");
    }

    @Override
    public void estimateCost() {
        System.out.println("Error: Cannot estimate costs in Delivery operation");
    }
}