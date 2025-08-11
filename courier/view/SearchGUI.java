package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;
import java.util.Optional;

public class SearchGUI {
    private final PackageManager manager;

    public SearchGUI(PackageManager manager) {
        this.manager = manager;
    }

    public Optional<Package> search(int id) {
        return manager.findById(id);
    }

    public boolean remove(int id) {
        return manager.removePackage(id);
    }
}
