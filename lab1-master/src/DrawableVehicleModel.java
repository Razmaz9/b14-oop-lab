package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawableVehicleModel {

    private final CarModel carModel = new CarModel();
    public List<DrawableVehicle> drawableVehicles = new ArrayList<>();
    public void addObserver(ICarObserver observer){
        carModel.addObserver(observer);
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

    private void addDrawableVehicle(Vehicle vehicle, String imageFileName) {
        DrawableVehicle drawableVehicle = new DrawableVehicle(vehicle, imageFileName);
        if (carModel.addVehicle(vehicle)) return;
        drawableVehicles.add(drawableVehicle);
        notifyObserversCarAdded();
    }

    private void addDrawableVehicle(Vehicle vehicle, String imageFileName, int x, int y) {
        DrawableVehicle drawableVehicle = new DrawableVehicle(vehicle, imageFileName);
        drawableVehicle.getPosition().x = x;
        drawableVehicle.getPosition().y = y;
        if (carModel.addVehicle(vehicle)) return;
        drawableVehicles.add(drawableVehicle);
        notifyObserversCarAdded();
    }

    public void removeLastVehicle() {
        if (!carModel.vehicles.isEmpty()) {
            carModel.removeVehicle();
            drawableVehicles.removeLast();
        }
        notifyObserversCarRemoved();
    }

    public void moveVehicles() {
        carModel.moveVehicles();
    }
    void gasAllCars(int amount){
        carModel.gasAllCars(amount);
    }

    void startEngineForAllCars(){
        carModel.startEngineForAllCars();
    }

    void stopEngineForAllCars(){
        carModel.stopEngineForAllCars();
    }

    void setTurboOnForSaabCars(){
        carModel.setTurboOnForSaabCars();
    }

    void setTurboOffForSaabCars(){
        carModel.setTurboOffForSaabCars();
    }

    void liftBedForScaniaTrucks(){
        carModel.liftBedForScaniaTrucks();
    }

    void lowerBedForScaniaTrucks(){
        carModel.lowerBedForScaniaTrucks();
    }

    void brakeAllCars(int amount) {
        carModel.brakeAllCars(amount);
    }

    public void addRandomDrawableVehicle() {
        Random rnd = new Random();
        int rndInt = rnd.nextInt(3);
        switch (rndInt) {
            case 0 -> addDrawableVolvo240();
            case 1 -> addDrawableSaab95();
            case 2 -> addDrawableScania();
            default -> throw new IllegalStateException("Unexpected value: " + rndInt);
        }
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
