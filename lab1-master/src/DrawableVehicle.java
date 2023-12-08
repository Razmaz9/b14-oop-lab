package src;

import java.awt.geom.Point2D;


public class DrawableVehicle {
    private final String imageFileName;
    private final Vehicle vehicle;
    public DrawableVehicle(Vehicle vehicle, String imageFileName) {
        this.vehicle = vehicle;
        this.imageFileName = imageFileName;
    }

    public Point2D.Double getPosition() {
        return vehicle.getPosition();
    }

    public String getImageFileName() {
        return imageFileName;
    }
}
