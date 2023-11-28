package src;

import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> implements RAStorage<T> {


    public List<T> storage = new ArrayList<>();
    private int maxStorage = 8;

    @Override
    public void storeItem(T vehicle) {
        if (storage.size() < maxStorage)
            storage.add(vehicle);
    }

    @Override
    public void removeItem(T car) {
        storage.remove(car);
    }

    @Override
    public int getMaxStorage() {
        return maxStorage;
    }

    @Override
    public void setMaxStorage(int num) {
        maxStorage = num;
    }
}