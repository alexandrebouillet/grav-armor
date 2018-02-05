package com.gravarmor.view;

import com.gravarmor.model.units.Infantry;
import com.gravarmor.model.units.Plane;
import com.gravarmor.model.units.Tank;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UnitsFrame extends JFrame{

    public UnitsFrame(){
        this.setTitle("Liste des unités");

        setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        Container content = this.getContentPane();
        //tanks
        Tank tank = new Tank(1, 3, "black", 3, "Gatling Lasers", 2,
                "black",getImage("data/aza3 red.png"),5, "black", "Aza3",
                3, "black","red", "alive", "blanc", -1, -1);

        //planes
        Plane plane = new Plane(2, 4, "black", 5, "Gatling Lasers", 3,
                "black",getImage("data/fl6 blue.png"),101, "black", "FL6",
                8, "white","blue", "alive", "black", -1, -1);

        //infantries
        Infantry infantry = new Infantry(3, 3, "white", 2, "Missiles", 3,
                "black",getImage("data/ainf blue.png"),2, "yellow", "A-INF",
                7, "black","blue", "alive", "black", -1, -1);

        JComboBox units = new JComboBox();
        units.addItem(tank.getUnitName());
        units.addItem(plane.getUnitName ());
        units.addItem(infantry.getUnitName ());
        units.setSize(125,50);
        units.setBounds(25, 25, 125, 25);

        JButton btn = new JButton();
        btn.setText("OK");
        btn.setSize(125,50);
        btn.setBounds(175, 25, 125, 25);

        this.add(units);
        this.add(btn);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        this.setSize( 325, 100);
        this.setResizable(false);
        this.setLocationRelativeTo( null );
        this.setLayout(null);

    }

    public static Image getImage(String path){
        Image image = null;
        try {
            File url = new File(path);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
