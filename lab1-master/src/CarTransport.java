package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Car implements StorageThings{

    private List<Car> storage = new ArrayList<>();
    private boolean platformIsOpen = true;

    public CarTransport() {
        super(2, 400, Color.CYAN, "Example Car Transport");
    }


    public void openPlatform(){
        platformIsOpen = true;
    }

    public void closePlatform(){
        platformIsOpen = false;
    }

    @Override
    public void storeVehicle(Car vehicle){
        int maxStorage = 4;
        if(
                !(vehicle instanceof VehiclesWithPlatform) && // Trucks and Car transport are too large to be loaded !
                getCurrentSpeed() == 0 &&
                checkIfLoadable(vehicle) &&
                getStorage().size() < maxStorage &&
                        isPlatformOpen())

            getStorage().add(vehicle);
    }

    @Override
    public void removeVehicle(){
        int lastIndex = getStorage().size() -1 ;
        Car vehicle = getStorage().get(lastIndex);
        if(isPlatformOpen())
            getStorage().remove(lastIndex);
        vehicle.setXCoordinate(getXCoordinate() - 1);
        vehicle.setYCoordinate(getYCoordinate() - 1);
    }

    private boolean checkIfLoadable(Car vehicle){
        double xDifferential = getXCoordinate() - vehicle.getXCoordinate();
        double yDifferential = getYCoordinate() - vehicle.getYCoordinate();
        return Math.abs(xDifferential) < 1 && Math.abs(yDifferential) < 1;  // If car is 1 coordinate unit away from car transport, return true, else false.
    }

    @Override
    public void move() {
        if(!isPlatformOpen()){
            super.move();
            for (Car vehicle : getStorage()) {
              vehicle.setXCoordinate(getXCoordinate());
              vehicle.setYCoordinate(getYCoordinate());
            }
        }
    }

    public List<Car> getStorage() {
        return storage;
    }

    public boolean isPlatformOpen() {
        return platformIsOpen;
    }
}
