package src;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Vehicle implements LIFOStorage<StorableCar> {

    private final List<StorableCar> storage = new ArrayList<>();
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
    public void storeItem(StorableCar vehicle) {
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
        StorableCar vehicle = getStorage().get(lastIndex);
        if (isPlatformOpen())
            getStorage().remove(lastIndex);
        vehicle.setXCoordinate(getXCoordinate() - 1);
        vehicle.setYCoordinate(getYCoordinate() - 1);
    }

    private boolean checkIfLoadable(StorableCar vehicle) {
        double xDifferential = getXCoordinate() - vehicle.getXCoordinate();
        double yDifferential = getYCoordinate() - vehicle.getYCoordinate();
        return Math.abs(xDifferential) < 1 && Math.abs(yDifferential) < 1;  // If car is 1 coordinate unit away from car transport, return true, else false.
    }

    @Override
    public void move() {
        if (!isPlatformOpen()) {
            super.move();
            for (StorableCar vehicle : getStorage()) {
                vehicle.setXCoordinate(getXCoordinate());
                vehicle.setYCoordinate(getYCoordinate());
            }
        }
    }

    @Override
    protected double calculateSpeedFactor() {
        return 1;
    }

    public List<StorableCar> getStorage() {
        return storage;
    }

    public boolean isPlatformOpen() {
        return platformIsOpen;
    }
}
