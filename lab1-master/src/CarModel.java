package src;

import java.util.ArrayList;

public class CarModel {

    ArrayList<Vehicle> vehicles = new ArrayList<>();


    ArrayList<ICarObserver> listOfObservers = new ArrayList<>();

    public void addObserver(ICarObserver frame){
        listOfObservers.add(frame);
    }

    private void notifyObservers(){
        for(ICarObserver frame : listOfObservers)
            frame.actOnVehicleMoved("CarMoved");
    }

    public void createCars(){
        Vehicle volvo = VehicleFactory.createVolvo240();
        Vehicle saab = VehicleFactory.createSaab95();
        Vehicle scania = VehicleFactory.createScania();

        saab.setYCoordinate(100);
        scania.setYCoordinate(200);

        vehicles.add(volvo);
        vehicles.add(saab);
        vehicles.add(scania);
    }

    public void moveVehicles() {
        for (Vehicle vehicle : vehicles) {
            int y = (int) Math.round(vehicle.getYCoordinate());
            if (y > 500 || y < 0) {
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
            vehicle.move();
            // repaint() calls the paintComponent method of the panel
            notifyObservers();
        }
    }
    void gasAllCars(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) { // Is empty?????
            vehicle.gas(gas);
        }
    }

    void startEngineForAllCars(){
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    void stopEngineForAllCars(){
        for (Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    void setTurboOnForSaabCars(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof HasTurbo)
                ((HasTurbo) vehicle).setTurboOn();
        }
    }

    void setTurboOffForSaabCars(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof HasTurbo)
                ((HasTurbo) vehicle).setTurboOff();
        }
    }

    void liftBedForScaniaTrucks(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof HasAngledPlatform)
                ((HasAngledPlatform) vehicle).setPlatformAngle(0);
        }
    }

    void lowerBedForScaniaTrucks(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof HasAngledPlatform)
                ((HasAngledPlatform) vehicle).setPlatformAngle(70);
        }
    }

    void brakeAllCars(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    public void addRandomVehicle() {

    }

    public void addVolvo240() {
        addVehicle(VehicleFactory.createVolvo240());
    }

    public void addSaab95() {
        addVehicle(VehicleFactory.createSaab95());
    }

    public void addScania() {
        addVehicle(VehicleFactory.createScania());
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicles.size() >= 10) return false;
        return vehicles.add(vehicle);
    }

    public void removeCar() {
        if (!vehicles.isEmpty()) vehicles.removeLast();
    }
}
