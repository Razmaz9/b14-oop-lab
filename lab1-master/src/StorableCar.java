package src;

import java.awt.*;

public abstract class StorableCar extends Car {
    protected StorableCar(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }
}
