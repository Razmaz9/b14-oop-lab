package src;

import java.awt.*;

public class Scania extends VehiclesWithPlatform {

    public Scania(){
        direction = 0;
        nrDoors = 2;
        color = Color.white;
        enginePower = 300;
        modelName = "Scania";
        xCoordinate = 0;
        yCoordinate = 0;
        maxAngle = 70;
        minAngle = 0;
        stopEngine();
    }




}
