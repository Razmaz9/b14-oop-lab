package src;

import java.awt.*;
import java.lang.reflect.Array;
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
        platformAngle = 0; // 1 = Ramp is up, transport can move. 0 = Ramp is down, transport can't move.
        stopEngine();
    }

    public List<Car> storage = new ArrayList<>();

    @Override
    public void setPlatformAngle(int angle) {
        if(angle <= 0)
            super.setPlatformAngle(0);
        else
            super.setPlatformAngle(1);
    }

    @Override
    public void storeVehicle(Car vehicle){
        int maxStorage = 4;
        if(
                !(vehicle instanceof VehiclesWithPlatform) && // Trucks and Car transport are too large to be loaded !
                getCurrentSpeed() == 0 &&
                checkIfLoadable(vehicle) &&
                storage.size() < maxStorage &&
                getPlatformAngle() == 0)

            storage.add(vehicle);
    }

    @Override
    public void removeVehicle(){
        int lastIndex = storage.size() -1 ;
        Car vehicle = storage.get(lastIndex);
        if(getPlatformAngle() == 0)
            storage.remove(lastIndex);
        vehicle.xCoordinate = getXCoordinate() - 1;
        vehicle.yCoordinate = getYCoordinate() - 1;
    }

    private boolean checkIfLoadable(Car vehicle){
        double xDifferential = getXCoordinate() - vehicle.getXCoordinate();
        double yDifferential = getYCoordinate() - vehicle.getYCoordinate();
        return Math.abs(xDifferential) < 1 && Math.abs(yDifferential) < 1;  // If car is 1 coordinate unit away from car transport, return true, else false.
    }

    @Override
    public void move() {
        if(platformAngle == 1){
            super.move();
            for (Car vehicle : storage) {
              vehicle.xCoordinate = getXCoordinate();
              vehicle.yCoordinate = getYCoordinate();
            }
        }
    }

}
