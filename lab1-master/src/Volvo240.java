package src;

import java.awt.*;

public class Volvo240 extends StorableCar {
    private static final double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.BLACK, "Volvo240");
    }


    @Override
    protected double calculateSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
