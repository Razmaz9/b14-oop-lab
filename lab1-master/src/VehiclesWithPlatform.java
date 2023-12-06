package src;

import java.awt.*;

public abstract class VehiclesWithPlatform extends Truck implements HasAngledPlatform {

    private final int maxAngle;
    private final int minAngle;
    private int platformAngle;

    protected VehiclesWithPlatform(int nrDoors, double enginePower, Color color, String modelName, int minAngle, int maxAngle) {
        super(nrDoors, enginePower, color, modelName);
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        setPlatformAngle(minAngle);
    }


    @Override
    public int getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public void setPlatformAngle(int angle) {
        if (getCurrentSpeed() == 0) {
            if (angle <= getMinAngle()) {
                platformAngle = getMinAngle();
            } else
                platformAngle = Math.min(angle, getMaxAngle());
        }
    }

    @Override
    public int getMaxAngle() {
        return maxAngle;
    }

    @Override
    public int getMinAngle() {
        return minAngle;
    }
}