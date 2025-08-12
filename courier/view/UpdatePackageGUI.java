package courier.view;

import courier.manager.PackageManager;

public class UpdatePackageGUI {
    private final PackageManager manager;

    public UpdatePackageGUI(PackageManager manager) {
        this.manager = manager;
    }

    public void update(int id, String status, String expectedArrival) {
        manager.findById(id).ifPresent(p -> {
            if (status != null && !status.isEmpty()) p.setStatus(status);
            if (expectedArrival != null && !expectedArrival.isEmpty()) p.setExpectedArrival(expectedArrival);
        });
    }
}
