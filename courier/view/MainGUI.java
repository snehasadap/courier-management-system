package courier.view;

import courier.manager.PackageManager;

public class MainGUI {
    private final PackageManager manager = new PackageManager();

    public void estimateCost() {
        double cost = manager.estimate(450);
        System.out.println("[estimateCost] Example cost for 450g: " + cost);
    }

    public void addPackage() {
        // TODO: hook up AddPackageGUI
    }

    public void updatePackage() {
        // TODO: hook up UpdatePackageGUI
    }

    public void displayAll() {
        System.out.println("[displayAll] Total packages: " + manager.all().size());
    }

    public void searchAll() {
        // TODO: hook up SearchGUI
    }

    public PackageManager manager() { return manager; }
}
