package com.gravarmor.view;

import com.gravarmor.model.units.Infantry;
import com.gravarmor.model.units.Plane;
import com.gravarmor.model.units.Tank;

import javax.swing.*;
import java.awt.*;

public class MoveFrame extends JFrame{

    public MoveFrame() {

        this.setTitle("Bouger !");

        setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        Container content = this.getContentPane();


        JComboBox move = new JComboBox();


        JButton btn = new JButton();
        btn.setText("Bouger !");
        btn.setSize(125,50);
        btn.setBounds(175, 25, 125, 25);

        this.add(move);
        this.add(btn);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        this.setSize( 325, 100);
        this.setResizable(false);
        this.setLocationRelativeTo( null );
        this.setLayout(null);
        this.setVisible(true);

    }
}
