package src;

import java.awt.*;

public abstract class VehiclesWithPlatform extends Car implements Movable {

    private int platformAngle;
    private int maxAngle;
    private int minAngle;

    public VehiclesWithPlatform(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }


    public int getPlatformAngle(){
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