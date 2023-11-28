package src;
import java.awt.*;
public class Saab95 extends Car {
    private boolean turboOn;
    public Saab95(){
        super(2, 125, Color.RED, "Saab95");
        turboOn = false;
        speedFactor = 1.25;
    }


    public void setTurboOn(){
        turboOn = true;
        speedFactor = getSpeedFactor() * 1.3;

    }
    public void setTurboOff(){
        turboOn = false;
        speedFactor = 1.25;
    }

 }

