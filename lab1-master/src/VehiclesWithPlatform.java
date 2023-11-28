package src;

import java.awt.*;

public abstract class VehiclesWithPlatform extends Vehicle {

    private final int maxAngle;
    private final int minAngle;
    private int platformAngle;

    protected VehiclesWithPlatform(int nrDoors, double enginePower, Color color, String modelName, int minAngle, int maxAngle) {
        super(nrDoors, enginePower, color, modelName);
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        setPlatformAngle(minAngle);
    }


    public int getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(int angle) {
        if (getCurrentSpeed() == 0) {
            if (angle <= getMinAngle()) {
                platformAngle = getMinAngle();
            } else
                platformAngle = Math.min(angle, getMaxAngle());
        }
    }

    public int getMaxAngle() {
        return maxAngle;
    }

    public int getMinAngle() {
        return minAngle;
    }
}