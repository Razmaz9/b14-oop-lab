package src;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private final int panelWidth;
    private final int panelHeight;
    DrawableVehicleModel model;
    JPanel mainPanel = new JPanel();

    JPanel controlPanel = new JPanel();

    CarController(DrawableVehicleModel model, int panelWidth, int panelHeight){
        this.model = model;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");

    JPanel startStopPanel = new JPanel();
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    int gasAmount = 0;

    public void initComponents() {
        mainPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });


        gasPanel.setPreferredSize(new Dimension(panelWidth / 5, panelHeight));
        gasPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gasPanel.add(gasLabel, gbc);
        gbc.gridy = 1;
        gasPanel.add(gasSpinner, gbc);

        mainPanel.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((panelWidth * 6 / 10 - 2), panelHeight));
        mainPanel.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startStopPanel.setPreferredSize(new Dimension(panelWidth * 2 / 10, panelHeight));
        startStopPanel.setLayout(new BorderLayout(0, 0));

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(panelWidth * 2 / 10, panelHeight / 2));
        startStopPanel.add(startButton, BorderLayout.PAGE_START);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(panelWidth * 2 / 10, panelHeight / 2));
        startStopPanel.add(stopButton, BorderLayout.PAGE_END);
        mainPanel.add(startStopPanel);

        startStopPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

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
                gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });

        // Make the frame pack all it's components by respecting the sizes if possible.
    }




    // Calls the gas method for each vehicle once
    void gas(int amount) {
        model.gasAllCars(amount);
    }

    void startEngine(){
        model.startEngineForAllCars();
    }

    void stopEngine(){
        model.stopEngineForAllCars();
    }

    void setTurboOnForSaab(){
        model.setTurboOnForSaabCars();
    }

    void setTurboOffForSaab(){
        model.setTurboOffForSaabCars();
    }

    void scaniaLiftBed(){
        model.liftBedForScaniaTrucks();
    }

    void scaniaLowerBed(){
        model.lowerBedForScaniaTrucks();
    }

    void brake(int amount){
        model.brakeAllCars(amount);
    }
}
