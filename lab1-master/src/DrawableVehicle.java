package src;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class DrawableVehicle {
    private String imageFileName;
    private Vehicle vehicle;
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
