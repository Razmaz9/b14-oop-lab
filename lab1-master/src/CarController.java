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
    CarView frame;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
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


    public void initComponents() {
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

        // Make the frame pack all it's components by respecting the sizes if possible.
        frame.pack();
    }

    public void moveVehicles() {
        for (Vehicle vehicle : vehicles) {
            int x = (int) Math.round(vehicle.getXCoordinate());
            int y = (int) Math.round(vehicle.getYCoordinate());
            if (y > 500 || y < 0) {
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
            vehicle.move();
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();

        }
    }


    // Calls the gas method for each vehicle once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void startEngine(){
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    void stopEngine(){
        for (Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    void setTurboOnForSaab(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof HasTurbo)
                ((HasTurbo) vehicle).setTurboOn();
        }
    }

    void setTurboOffForSaab(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof HasTurbo)
                ((HasTurbo) vehicle).setTurboOff();
        }
    }

    void scaniaLiftBed(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof HasAngledPlatform)
                ((HasAngledPlatform) vehicle).setPlatformAngle(0);
        }
    }

    void scaniaLowerBed(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof HasAngledPlatform)
                ((HasAngledPlatform) vehicle).setPlatformAngle(70);
        }
    }


    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
}
