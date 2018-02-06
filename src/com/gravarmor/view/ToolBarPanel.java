package com.gravarmor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarPanel extends JPanel {

    private ImageIcon diceImage = new ImageIcon("data/rolling-dices.png");
    private ImageIcon turnImage = new ImageIcon("data/turns.png");
    private ImageIcon unitsImage = new ImageIcon("data/units.png");
    public ToolBarPanel() {
        JButton btnDices = new JButton(new ImageIcon(this.diceImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)));
        btnDices.addActionListener(e -> {

        });

        JButton btnContinue = new JButton(new ImageIcon(this.turnImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)));
        btnContinue.addActionListener(e -> {

        });

        JButton btnUnits = new JButton(new ImageIcon(this.unitsImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)));
        btnUnits.addActionListener(e -> {
//            UnitsFrame units = new UnitsFrame();
//            units.setVisible(true);
        });

        this.add(btnDices);
        this.add(btnContinue);
        this.add(btnUnits);
    }
}
