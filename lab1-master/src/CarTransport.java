package src;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Vehicle implements LIFOStorage<Car> {

    private final List<Car> storage = new ArrayList<>();
    private boolean platformIsOpen = true;
    private int maxStorage;

    public CarTransport() {
        super(2, 400, Color.CYAN, "Example Car Transport");
        setMaxStorage(8);
    }


    public void openPlatform() {
        platformIsOpen = true;
    }

    public void closePlatform() {
        platformIsOpen = false;
    }

    @Override
    public void storeItem(Car vehicle) {
        if (
                getCurrentSpeed() == 0 &&
                        checkIfLoadable(vehicle) &&
                        getStorage().size() < getMaxStorage() &&
                        isPlatformOpen())

            getStorage().add(vehicle);
    }

    @Override
    public int getMaxStorage() {
        return maxStorage;
    }

    @Override
    public void setMaxStorage(int num) {
        maxStorage = num;
    }

    @Override
    public void removeLastItem() {
        int lastIndex = getStorage().size() - 1;
        Car vehicle = getStorage().get(lastIndex);
        if (isPlatformOpen())
            getStorage().remove(lastIndex);
        vehicle.setXCoordinate(getXCoordinate() - 1);
        vehicle.setYCoordinate(getYCoordinate() - 1);
    }

    private boolean checkIfLoadable(Car vehicle) {
        double xDifferential = getXCoordinate() - vehicle.getXCoordinate();
        double yDifferential = getYCoordinate() - vehicle.getYCoordinate();
        return Math.abs(xDifferential) < 1 && Math.abs(yDifferential) < 1;  // If car is 1 coordinate unit away from car transport, return true, else false.
    }

    @Override
    public void move() {
        if (!isPlatformOpen()) {
            super.move();
            for (Car vehicle : getStorage()) {
                vehicle.setXCoordinate(getXCoordinate());
                vehicle.setYCoordinate(getYCoordinate());
            }
        }
    }

    @Override
    protected double calculateSpeedFactor() {
        return 1;
    }

    public List<Car> getStorage() {
        return storage;
    }

    public boolean isPlatformOpen() {
        return platformIsOpen;
    }
}
