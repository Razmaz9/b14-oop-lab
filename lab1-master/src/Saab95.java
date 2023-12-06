package src;

import java.awt.*;

public class Saab95 extends StorableCar implements HasTurbo {
    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.RED, "Saab95");
        turboOn = false;
    }


    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    @Override
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double calculateSpeedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}