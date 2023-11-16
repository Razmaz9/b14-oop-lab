package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Vehicles_with_platform implements StorageThings{
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

    Car testSaab = new Saab95();
    List<Car> storage = new ArrayList<>();


    @Override
    public void storeVehicle(){
        storage.add(testSaab);
    }

    @Override
    public void removeVehicle(){
    }

    @Override
    public List getStorage(){
        return storage;
    }
    @Override
    public boolean canMoveCheck(){
        return getPlatformPosition() == maxAngle;
    }
}
