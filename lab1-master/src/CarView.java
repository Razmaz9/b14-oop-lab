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

public class CarView extends JFrame implements ICarObserver{
    private static final int X = 800;
    private static final int Y = 800;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);



    // Constructor
    public CarView(String framename){
        initComponents(framename);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    public void actOnModelChange(String reason) {
        if (Objects.equals(reason, "CarMoved"))
            drawPanel.repaint();
    }
}