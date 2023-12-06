package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {


    //<editor-fold desc="Timer: does not belong in Controller">
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());
    //</editor-fold>

    private CarController carController;
    private CarView carView;

    //<editor-fold desc="main(): Does not belong in Controller. Application?">
    public static void main(String[] args) {
        // Instance of this class
        Application app = new Application();

        app.carController = new CarController();

        // Start a new view and send a reference of self
        app.carView = new CarView("CarSim 1.0");
        app.setCarViewLocation();
        app.carController.frame = app.carView;
        app.carController.initComponents();

        Vehicle volvo = VehicleFactory.createVolvo240();
        Vehicle saab = VehicleFactory.createSaab95();
        Vehicle scania = VehicleFactory.createScania();

        saab.setYCoordinate(100);
        scania.setYCoordinate(200);

        app.addVehicle(volvo, "Volvo240.jpg");
        app.addVehicle(saab, "Saab95.jpg");
        app.addVehicle(scania, "Scania.jpg");

        // Start the timer
        app.timer.start();
    }
    //</editor-fold>

    //<editor-fold desc="Timer related: does not belong in Controller">
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carController.moveVehicles();
        }
    }
    //</editor-fold>

    private void setCarViewLocation() {
        //<editor-fold desc="Handles frame placement. Should be done by application instead?">
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        carView.setLocation(dim.width / 2 - carView.getSize().width / 2, dim.height / 2 - carView.getSize().height / 2);
        //</editor-fold>

    }

    private void addVehicle(Vehicle vehicle, String imageFileName) {
        carController.vehicles.add(vehicle);
        carView.addVehicle(vehicle.position, imageFileName);
    }

}
