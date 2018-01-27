package com.gravarmor.view;

import javax.swing.*;
import java.awt.*;

public class UnitsFrame extends JFrame{

    public UnitsFrame(){
        this.setTitle("Liste des unités");

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container content = this.getContentPane();

        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        this.setSize( 250, 250);
        this.setResizable(false);
        this.setLocationRelativeTo( null );

    }
}
