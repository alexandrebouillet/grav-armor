package com.gravarmor.view;

import javax.swing.*;
import java.awt.*;

public class FireFrame extends JFrame {

    public FireFrame() {

        this.setTitle("Attaquer !");

        setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        Container content = this.getContentPane();


        JComboBox move = new JComboBox();


        JButton btn = new JButton();
        btn.setText("Attaquer !");
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
