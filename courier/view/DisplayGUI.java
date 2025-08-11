package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;
import java.util.List;

public class DisplayGUI {
    private final PackageManager manager;

    public DisplayGUI(PackageManager manager) {
        this.manager = manager;
    }

    public List<Package> tableModel() {
        return manager.all();
    }
}
