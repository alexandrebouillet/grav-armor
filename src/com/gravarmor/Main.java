package com.gravarmor;

import com.gravarmor.model.hexgrid.*;
import com.gravarmor.view.HexGridPanel;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {

        HexGridPanel panel = new HexGridPanel();
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Grav Armor");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container content = frame.getContentPane();
        content.add(panel);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        frame.setSize( 1366, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);

    }
}
