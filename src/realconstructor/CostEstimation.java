package realconstructor;

import java.text.NumberFormat;
import java.util.Locale;

public class CostEstimation extends ConstructionMaterial {
    public CostEstimation(String contractorId, String contractorName, double materialQuantity) {
        super(contractorId, contractorName, materialQuantity);
    }

    @Override
    public void receiveMaterial() {
        System.out.println("Error: Cannot receive materials in Cost Estimation");
    }

    @Override
    public void useMaterial() {
        System.out.println("Error: Cannot use materials in Cost Estimation");
    }

    @Override
    public void estimateCost() {
        if (materialQuantity < 5) {
            System.out.println("Error: Minimum 5 tons required for cost estimation");
            return;
        }

        double costPerTon = materialQuantity > 15 ? 180000 : 200000;
        double totalCost = materialQuantity * costPerTon;

        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        fmt.setMaximumFractionDigits(0);

        System.out.println("\n=== COST ESTIMATION ===");
        System.out.println("Contractor: " + contractorName + " (" + contractorId + ")");
        System.out.printf("Material Quantity: %.2f tons%n", materialQuantity);
        System.out.println("Rate: " + fmt.format(costPerTon) + " per ton");
        System.out.println("Total Cost: " + fmt.format(totalCost));
    }
}