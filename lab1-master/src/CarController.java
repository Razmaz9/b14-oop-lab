package src;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    //</editor-fold>
    
    //<editor-fold desc="Create buttons, panels and labels">
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    //</editor-fold>


    //methods:


    public void initComponents() {
        //<editor-fold desc="Set layout and add components">
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                frame.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((800/2)+4, 200));
        frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(800/5-15,200));
        frame.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(800/5-15,200));
        frame.add(stopButton);
        //</editor-fold>

        //<editor-fold desc="Add ActionListeners for buttons">

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scaniaLowerBed();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scaniaLiftBed();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOnForSaab();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOffForSaab();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEngine();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopEngine();
            }
        });
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.gasAmount);
            }
        });
        //</editor-fold>

        // Make the frame pack all it's components by respecting the sizes if possible.
        frame.pack();
    }

    public void moveVehicles() {
        for (Vehicle car : vehicles) {
            int x = (int) Math.round(car.getXCoordinate());
            int y = (int) Math.round(car.getYCoordinate());
            if (y > 500 || y < 0) {
                car.turnLeft();
                car.turnLeft();
            }
            car.move();
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.gas(gas);
        }
    }

    void startEngine(){
        for (Vehicle car : vehicles){
            car.startEngine();
        }
    }

    void stopEngine(){
        for (Vehicle car : vehicles){
            car.stopEngine();
        }
    }

    void setTurboOnForSaab(){
        for (Vehicle car : vehicles){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    void setTurboOffForSaab(){
        for (Vehicle car : vehicles){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void scaniaLiftBed(){
        for (Vehicle car : vehicles) {
            if (car instanceof Scania)
                ((Scania) car).setPlatformAngle(0);
        }
    }

    void scaniaLowerBed(){
        for (Vehicle car : vehicles) {
            if (car instanceof Scania)
                ((Scania) car).setPlatformAngle(70);
        }
    }


    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(brake);
        }
    }
}
