package courier.manager;

import courier.model.Package;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PackageManager {
    private final List<Package> packageList = new ArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(100000);

    public Package add(int weight, String description, String destination,
                       String mailedDate, String expectedArrival) {
        int id = nextId.getAndIncrement();
        Package p = new Package(id, weight, description, destination, mailedDate, expectedArrival);
        packageList.add(p);
        return p;
    }

    public boolean removePackage(int id) {
        return packageList.removeIf(p -> p.getId() == id);
    }

    public Optional<Package> findById(int id) {
        return packageList.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Package> all() {
        return Collections.unmodifiableList(packageList);
    }

    public double estimate(int weight) {
        return 5.0 + 0.75 * Math.ceil(Math.max(0, weight) / 100.0);
    }
}
