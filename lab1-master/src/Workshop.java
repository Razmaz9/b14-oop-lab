package src;
import java.util.List;
import java.util.ArrayList;
public class Workshop<T extends Car> implements StorageThings<T> {



    private int maxStorage = 8;

    public List<T> storage = new ArrayList<>();

    @Override
    public void storeVehicle(T vehicle){
        if(storage.size() < maxStorage)
            storage.add(vehicle);
    }

    @Override
    public void removeVehicle(){
    }

    public void removeVehicle(T vehicle){
        storage.remove(vehicle);
    }
    public int getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(int num){
        maxStorage = num;
    }
}
