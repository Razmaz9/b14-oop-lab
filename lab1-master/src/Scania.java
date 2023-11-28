package src;

import java.awt.*;

public class Scania extends VehiclesWithPlatform {

    public Scania(){
        super(2, 300, Color.WHITE, "Scania", 0, 70);
        speedFactor = 1;
    }



    @Override
    public void move() {
        if(platformAngle == 0)
            super.move();
    }
}
