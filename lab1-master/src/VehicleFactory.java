package src;

public class VehicleFactory {
    public static Vehicle createSaab95() {
        return Saab95Factory.createSaab95();
    }

    public static Vehicle createScania() {
        return ScaniaFactory.createScania();
    }

    public static Vehicle createVolvo240() {
        return Volvo240Factory.createVolvo240();
    }
}
