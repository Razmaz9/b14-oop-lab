package src;

public abstract class VehiclesWithPlatform extends Car implements Movable {

    public int platformAngle;
    public int maxAngle;
    public int minAngle;


    public int getPlatformAngle(){
        return platformAngle;
    }

    public void setPlatformAngle(int angle) {
        if (getCurrentSpeed() == 0) {
            if (angle <= minAngle) {
                platformAngle = minAngle;
            } else
                platformAngle = Math.min(angle, maxAngle);
        }
    }

}

