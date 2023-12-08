package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    private final int preferredWidth;
    private final int preferredHeight;

    private Application(int preferredWidth, int preferredHeight) {
        this.preferredWidth = preferredWidth;
        this.preferredHeight = preferredHeight;
    }

    //<editor-fold desc="Timer: does not belong in Controller">
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());
    //</editor-fold>

    private final JFrame mainFrame = new JFrame();

    private void initFrame(String title) {
        mainFrame.setTitle(title);
        mainFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = calculateGridBagConstraints(0, 0, 2, 1);
        mainFrame.add(carView, gbc);
        gbc = calculateGridBagConstraints(0, 1, 1, 1);
        mainFrame.add(carController.mainPanel, gbc);
        gbc = calculateGridBagConstraints(1, 1, 1, 1);
        mainFrame.add(addCarController.mainPanel, gbc);

        carView.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        carController.mainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        addCarController.mainPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private GridBagConstraints calculateGridBagConstraints(int x, int y, int width, int height) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        return gbc;
    }

    private AddCarController addCarController;
    private CarController carController;
    private CarView carView;
    private static DrawableVehicleModel model;

    //<editor-fold desc="main(): Does not belong in Controller. Application?">
    public static void main(String[] args) {
        // Instance of this class
        Application app = new Application(800, 800);

        model = new DrawableVehicleModel();
        app.addCarController = new AddCarController(model, 100, 240);
        app.carController = new CarController(model, app.preferredWidth - 100, 240);


        // Start a new view and send a reference of self
        app.carView = new CarView(model, app.preferredWidth, app.preferredHeight - 240);
        app.setCarViewLocation();
        model.addObserver(app.carView);
        app.carController.initComponents();

        // UGLY CODE !!!!
        model.addDrawableVolvo240();
        model.addDrawableSaab95(0, 100);
        model.addDrawableScania(0, 200);

        app.initFrame("VehicleSim 2.0");

        // Start the timer
        app.timer.start();
    }
    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.moveVehicles();
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


}
