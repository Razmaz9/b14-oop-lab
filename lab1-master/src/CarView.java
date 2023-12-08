package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JPanel implements ICarObserver{
    private final int preferredWidth;
    private final int preferredHeight;

    DrawPanel drawPanel;
    DrawableVehicleModel model;


    // Constructor
    public CarView(DrawableVehicleModel model, int preferredWidth, int preferredHeight){
        this.model = model;
        this.preferredWidth = preferredWidth;
        this.preferredHeight = preferredHeight;
        initComponents();
    }

    private void initComponents() {
        drawPanel = new DrawPanel(preferredWidth, preferredHeight);
        this.setPreferredSize(new Dimension(preferredWidth, preferredHeight));

        this.add(drawPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.

        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
    }

    public void addVehicle(Point2D.Double point, String imageFileName) {
        drawPanel.addVehicle(new Pair<>(point, getBufferedImage(imageFileName)));
    }

    private BufferedImage getBufferedImage(String imageFileName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + imageFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public void actOnVehicleMoved() {
            drawPanel.repaint();
    }

    @Override
    public void actOnVehicleAdded() {
        DrawableVehicle vehicle = model.drawableVehicles.getLast();
        addVehicle(vehicle.getPosition(), vehicle.getImageFileName());
    }

    @Override
    public void actOnVehicleRemoved() {
        drawPanel.clearList();
        drawPanel.repaint();
        for (DrawableVehicle vehicle: model.drawableVehicles) {
            addVehicle(vehicle.getPosition(), vehicle.getImageFileName());
        }
    }
}