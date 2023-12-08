package src;

public interface ICarObserver {

    void actOnVehicleMoved(String reason);
    void actOnVehicleAdded();
    void actOnVehicleRemoved();
}
