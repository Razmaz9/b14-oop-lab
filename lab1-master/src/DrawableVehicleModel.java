package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawableVehicleModel {

    private CarModel carModel = new CarModel();
    public List<DrawableVehicle> drawableVehicles = new ArrayList<>();
    public void addObserver(ICarObserver observer){
        carModel.addObserver(observer);
    }

    private void notifyObserversCarMoved(){
        for(ICarObserver observer : carModel.listOfObservers) {
            observer.actOnVehicleMoved("CarMoved");
        }
    }

    private void notifyObserversCarAdded(){
        for(ICarObserver observer : carModel.listOfObservers) {
            observer.actOnVehicleAdded();
        }
    }

    private void notifyObserversCarRemoved(){
        for(ICarObserver observer : carModel.listOfObservers) {
            observer.actOnVehicleRemoved();
        }
    }

    public void createCars(){
        Vehicle volvo = VehicleFactory.createVolvo240();
        Vehicle saab = VehicleFactory.createSaab95();
        Vehicle scania = VehicleFactory.createScania();

        saab.setYCoordinate(100);
        scania.setYCoordinate(200);

        addDrawableVehicle(volvo, "Volvo240.jpg");
        addDrawableVehicle(saab, "Saab95.jpg");
        addDrawableVehicle(scania, "Scania.jpg");
    }

    private void addDrawableVehicle(Vehicle vehicle, String imageFileName) {
        DrawableVehicle drawableVehicle = new DrawableVehicle(vehicle, imageFileName);
        if (!carModel.addVehicle(vehicle)) return;
        drawableVehicles.add(drawableVehicle);
        notifyObserversCarAdded();
    }

    private void addDrawableVehicle(Vehicle vehicle, String imageFileName, int x, int y) {
        DrawableVehicle drawableVehicle = new DrawableVehicle(vehicle, imageFileName);
        drawableVehicle.getPosition().x = x;
        drawableVehicle.getPosition().y = y;
        if (!carModel.addVehicle(vehicle)) return;
        drawableVehicles.add(drawableVehicle);
        notifyObserversCarAdded();
    }

    public void removeLastVehicle() {
        if (!carModel.vehicles.isEmpty()) {
            carModel.vehicles.removeLast();
            drawableVehicles.removeLast();
        }
        notifyObserversCarRemoved();
    }

    public void moveVehicles() {
        for (Vehicle vehicle : carModel.vehicles) {
            int y = (int) Math.round(vehicle.getYCoordinate());
            if (y > 500 || y < 0) {
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
            vehicle.move();
            // repaint() calls the paintComponent method of the panel
            notifyObserversCarMoved();
        }
    }
    void gasAllCars(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : carModel.vehicles) { // Is empty?????
            vehicle.gas(gas);
        }
    }

    void startEngineForAllCars(){
        for (Vehicle vehicle : carModel.vehicles){
            vehicle.startEngine();
        }
    }

    void stopEngineForAllCars(){
        for (Vehicle vehicle : carModel.vehicles){
            vehicle.stopEngine();
        }
    }

    void setTurboOnForSaabCars(){
        for (Vehicle vehicle : carModel.vehicles){
            if(vehicle instanceof HasTurbo)
                ((HasTurbo) vehicle).setTurboOn();
        }
    }

    void setTurboOffForSaabCars(){
        for (Vehicle vehicle : carModel.vehicles){
            if(vehicle instanceof HasTurbo)
                ((HasTurbo) vehicle).setTurboOff();
        }
    }

    void liftBedForScaniaTrucks(){
        for (Vehicle vehicle : carModel.vehicles) {
            if (vehicle instanceof HasAngledPlatform)
                ((HasAngledPlatform) vehicle).setPlatformAngle(0);
        }
    }

    void lowerBedForScaniaTrucks(){
        for (Vehicle vehicle : carModel.vehicles) {
            if (vehicle instanceof HasAngledPlatform)
                ((HasAngledPlatform) vehicle).setPlatformAngle(70);
        }
    }

    void brakeAllCars(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : carModel.vehicles) {
            vehicle.brake(brake);
        }
    }

    public void addRandomVehicle() {
        Random rnd = new Random();
        int rndInt = rnd.nextInt(3);
        switch (rndInt) {
            case 0 -> addDrawableVolvo240();
            case 1 -> addDrawableSaab95();
            case 2 -> addDrawableScania();
            default -> throw new IllegalStateException("Unexpected value: " + rndInt);
        };
    }

    public void addDrawableVolvo240() {
        addDrawableVehicle(VehicleFactory.createVolvo240(), "Volvo240.jpg");
    }

    public void addDrawableVolvo240(int x, int y) {
        addDrawableVehicle(VehicleFactory.createVolvo240(), "Volvo240.jpg", x, y);
    }

    public void addDrawableSaab95() {
        addDrawableVehicle(VehicleFactory.createSaab95(), "Saab95.jpg");
    }

    public void addDrawableSaab95(int x, int y) {
        addDrawableVehicle(VehicleFactory.createSaab95(), "Saab95.jpg", x, y);
    }

    public void addDrawableScania() {
        addDrawableVehicle(VehicleFactory.createScania(), "Scania.jpg");
    }

    public void addDrawableScania(int x, int y) {
        addDrawableVehicle(VehicleFactory.createScania(), "Scania.jpg", x, y);
    }
}
