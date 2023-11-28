package src;
import java.util.List;
import java.util.ArrayList;
public class Workshop<T extends Car> implements RAStorage<T> {



    private int maxStorage = 8;

    public List<T> storage = new ArrayList<>();

    @Override
    public void storeVehicle(T vehicle){
        if(storage.size() < maxStorage)
            storage.add(vehicle);
    }

    @Override
    public void removeItem(T car){
        storage.remove(car);
    }

    @Override
    public int getMaxStorage() {
        return maxStorage;
    }

    @Override
    public void setMaxStorage(int num){
        maxStorage = num;
    }
}
