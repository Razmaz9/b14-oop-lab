package src;

import java.awt.*;

public class Scania extends VehiclesWithPlatform {

    public Scania() {
        super(2, 300, Color.WHITE, "Scania", 0, 70);
    }


    @Override
    public void gas(double amount) {
        if (getPlatformAngle() == 0)
            super.gas(amount);
    }

    @Override
    protected double calculateSpeedFactor() {
        return 1;
    }
}
