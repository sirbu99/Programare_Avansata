package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public JSpinner getSidesField() {
        return sidesField;
    }

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        String[] colors = {"Black", "Random"};
        colorCombo = new JComboBox(colors);

        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }
}
