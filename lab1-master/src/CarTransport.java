package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends VehiclesWithPlatform implements StorageThings{
    public CarTransport(){
        direction = 0;
        nrDoors = 2;
        color = Color.cyan;
        enginePower = 400;
        modelName = "Example Car Transport";
        xCoordinate = 0;
        yCoordinate = 0;
        maxAngle = 1;
        minAngle = 0;
        stopEngine();
    }


    List<Car> storage = new ArrayList<>();


    @Override
    public void storeVehicle(Car vehicle){
        storage.add(vehicle);
    }

    @Override
    public void removeVehicle(){
    }
    @Override
    public List<?> getStorage(){
        return storage;
    }

}
