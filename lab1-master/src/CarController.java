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

    //<editor-fold desc="Timer: does not belong in Controller">
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());
    //</editor-fold>

    //<editor-fold desc="Should not depend on specific View. Observer?">
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //</editor-fold>

    //<editor-fold desc="Should Controller hold instances of Model?">
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    //</editor-fold>

    //methods:

    //<editor-fold desc="main(): Does not belong in Controller. Application?">
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Vehicle volvo = new Volvo240();
        Vehicle saab = new Saab95();
        Vehicle scania = new Scania();

        saab.setYCoordinate(100);
        scania.setYCoordinate(200);

        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
    //</editor-fold>

    //<editor-fold desc="Timer related: does not belong in Controller">
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                int x = (int) Math.round(car.getXCoordinate());
                int y = (int) Math.round(car.getYCoordinate());
                if(y > 500 || y < 0){
                    car.turnLeft();
                    car.turnLeft();
                }
                car.move();
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }
    //</editor-fold>

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
