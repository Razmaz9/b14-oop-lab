package src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private final ArrayList<Pair<Point2D.Double, BufferedImage>> pointImagePairs = new ArrayList<>();


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pair<Point2D.Double, BufferedImage> pointImagePair : pointImagePairs) {
            g.drawImage(pointImagePair.second, (int)pointImagePair.first.x, (int)pointImagePair.first.y, null); // see javadoc for more info on the parameters
        }
    }

    public void addVehicle(Pair<Point2D.Double, BufferedImage> pointImagePair) {
        this.pointImagePairs.add(pointImagePair);
    }

    public void clearList() {
        pointImagePairs.clear();
    }
}
