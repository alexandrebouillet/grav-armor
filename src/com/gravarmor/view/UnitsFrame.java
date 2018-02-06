package com.gravarmor.view;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.units.Infantry;
import com.gravarmor.model.units.Plane;
import com.gravarmor.model.units.Tank;
import com.gravarmor.model.units.Unit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UnitsFrame extends JFrame{

    private Unit[] unitArray ;


    public Unit[] getUnitArray() {
        return unitArray;
    }

    public void setUnitArray(Unit[] unitArray) {
        this.unitArray = unitArray;
    }

    public UnitsFrame(Hexagon hex, Component component){
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

        this.unitArray = new Unit[]{tank, plane, infantry};
        System.out.println(this.unitArray);

        JComboBox units = new JComboBox();

        for (Unit unit : unitArray) {
            units.addItem(unit.getUnitName());
        }

        System.out.println(this.getComponents().length);
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
        this.setVisible(true);

        btn.addActionListener(e -> {
            System.out.println("MenuItem clicked.");
//            UnitsFrame unit = new UnitsFrame(hex, component);
            int x = hex.getX();
            int y = hex.getY();
//            System.out.println(x);
//            System.out.println(y);
            Unit[] unitsArray = this.getUnitArray();

//            System.out.println(unitsArray[0].getUnitName());
//            System.out.println(unitsArray[1].getUnitName());
//            System.out.println(unitsArray[2].getUnitName());

            Object unitSelected = units.getSelectedItem();

            for (Unit unitCheck: unitsArray) {
                if (unitCheck.getUnitName()==unitSelected){
//                    System.out.println(unitSelected);
//                    System.out.println(unitCheck.getUnitName());
                    unitCheck.place(unitCheck, x, y);
                    hex.setUnit(unitCheck);
                    hex.getCenterPoint();
                    Graphics g = this.getGraphics();
                    Graphics2D g2 = (Graphics2D)g;
                    hex.drawHexagon(g2);
                    g2.setBackground(Color.red);
//                    hex.get
//
//                    System.out.println(hex.getCenterPoint());
//                    System.out.println(x);
//                    System.out.println(y);

                    Image img = unitCheck.getUnitPicture();
//                    hex.getUnit().setUnitPicture(img);

//                    addPicture(img, x, y, component);

                    this.setIconImage(img);
                    this.setVisible(false);

                }
            }

        });

    }

    public void addPicture(Image img, int x, int y, Component component){
        Graphics g = img.getGraphics();

//        ImageObserver imgO = (ImageObserver)img;
        g.drawImage(img, x, y, component);
        System.out.println(component);
        this.setIconImage(img);

//        Graphics2D g2 =  (Graphics2D)g;
//        BufferedImageOp imgObs = (BufferedImageOp)img;
//        g2.drawImage((BufferedImage) img, imgObs, x, y);
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
