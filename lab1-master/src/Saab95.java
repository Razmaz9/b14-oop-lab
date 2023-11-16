package src;
import java.awt.*;
public class Saab95 extends Car {
    private boolean turboOn;
    public Saab95(){
        direction = 0;
        xCoordinate = 0;
        yCoordinate = 0;
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        speedFactor = 1.25;
        stopEngine();
    }


    public void setTurboOn(){
        turboOn = true;
        speedFactor = speedFactor * 1.3;

    }
    public void setTurboOff(){
        turboOn = false;
        speedFactor = 1.25;
    }

 }

