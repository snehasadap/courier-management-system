package courier.view;

import courier.manager.PackageManager;

public class CostEstimateGUI {
    private final PackageManager manager;

    public CostEstimateGUI(PackageManager manager) {
        this.manager = manager;
    }

    public double estimate(int weight) {
        return manager.estimate(weight);
    }
}
