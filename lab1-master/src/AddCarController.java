package src;

import javax.swing.*;
import java.awt.*;

public class AddCarController {

    private final DrawableVehicleModel model;
    private final int preferredWidth;
    private final int preferredHeight;
    JPanel mainPanel = new JPanel();

    public AddCarController(DrawableVehicleModel model, int preferredWidth, int preferredHeight) {
        this.model = model;
        this.preferredWidth = preferredWidth;
        this.preferredHeight = preferredHeight;
        initComponents();
    }

    private void initComponents() {

        mainPanel.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        mainPanel.setLayout(new GridBagLayout());
        addRemoveCarButtonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        addRemoveCarButtonsPanel.add(addCarButton, gbc);
        mainPanel.add(addRemoveCarButtonsPanel, gbc);
        gbc.gridy = 1;
        addRemoveCarButtonsPanel.add(removeCarButton, gbc);
        mainPanel.add(choices, gbc);

        addCarButton.addActionListener(e -> {
            switch (choices.getSelectedIndex()) {
                case 0 -> model.addRandomDrawableVehicle();
                case 1 -> model.addDrawableVolvo240();
                case 2 -> model.addDrawableSaab95();
                case 3 -> model.addDrawableScania();
            }
        });
        removeCarButton.addActionListener(e -> model.removeLastVehicle());
    }

    JPanel addRemoveCarButtonsPanel = new JPanel();
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");
    JComboBox<String> choices = new JComboBox<>(new String[]{"Random", "Volvo240", "Saab95", "Scania"});
}
