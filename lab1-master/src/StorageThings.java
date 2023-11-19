package src;

import java.util.List;

public interface StorageThings<T extends Car> {
    void storeVehicle(T vehicle);
    void removeVehicle();

}
