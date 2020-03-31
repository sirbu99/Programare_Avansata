package com.company;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox<String> colorCombo; // the color of the shape
    JComboBox<String> shapeCombo;

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
        colorCombo = new JComboBox<>(colors);
        String[] shapes = {"RegularPolygon", "Circle"};
        shapeCombo = new JComboBox<>(shapes);

        add(sidesLabel); //JPanel uses FlowLayout by default

        add(sidesField);
        add(colorCombo);
        add(shapeCombo);
    }
    public void updatePanel(int index){
        if (index==0)
        {
            removeAll();
            JLabel sidesLabel = new JLabel("Number of sides:");
            add(sidesLabel);
            add(sidesField);
            add(colorCombo);
            add(shapeCombo);
        }
        else if(index==1)
        {
            removeAll();
            add(colorCombo);
            add(shapeCombo);

        }
    }
}

