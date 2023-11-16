package src;

import java.util.List;

public interface StorageThings {
    void storeVehicle(Car vehicle);
    void removeVehicle();
    List<?> getStorage();
}
