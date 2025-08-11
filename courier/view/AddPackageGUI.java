package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

public class AddPackageGUI {
    private final PackageManager manager;

    public AddPackageGUI(PackageManager manager) {
        this.manager = manager;
    }

    public Package save(int weight, String description, String destination, String mailedDate, String expectedArrival) {
        return manager.add(weight, description, destination, mailedDate, expectedArrival);
    }
}
