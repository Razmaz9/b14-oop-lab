package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    //<editor-fold desc="Should not depend on specific View. Observer?">
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //</editor-fold>

    //<editor-fold desc="Should Controller hold instances of Model?">
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    //</editor-fold>

    //methods:

    public void moveVehicles() {
        for (Vehicle car : cars) {
            int x = (int) Math.round(car.getXCoordinate());
            int y = (int) Math.round(car.getYCoordinate());
            if (y > 500 || y < 0) {
                car.turnLeft();
                car.turnLeft();
            }
            car.move();
            frame.drawPanel.moveit(x, y, car);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void startEngine(){
        for (Vehicle car : cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (Vehicle car : cars){
            car.stopEngine();
        }
    }

    void setTurboOnForSaab(){
        for (Vehicle car : cars){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    void setTurboOffForSaab(){
        for (Vehicle car : cars){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void scaniaLiftBed(){
        for (Vehicle car : cars) {
            if (car instanceof Scania)
                ((Scania) car).setPlatformAngle(0);
        }
    }

    void scaniaLowerBed(){
        for (Vehicle car : cars) {
            if (car instanceof Scania)
                ((Scania) car).setPlatformAngle(70);
        }
    }


    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }
}
