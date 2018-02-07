package com.gravarmor.view;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.hexgrid.Hexagrid;
import com.gravarmor.model.units.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopHexMenu extends JPopupMenu {


    public PopHexMenu(Hexagon hex, Component component, Hexagrid hexBoard){
        JMenuItem unitsMenu = new JMenuItem("Placer une unités");
        JMenuItem turnMenu = new JMenuItem("Finir le tour");



        this.add(unitsMenu);
        this.add(turnMenu);
        if(hex.getUnit() != null){
            JMenuItem fireMenu = new JMenuItem("Attaquer !");
            JMenuItem moveMenu = new JMenuItem("Bouger !");
            this.add(fireMenu);
            this.add(moveMenu);

            fireMenu.addActionListener(e -> {
                System.out.println("Fire MenuItem clicked.");
                new FireFrame(hex, component, hexBoard);
            });
            moveMenu.addActionListener(e -> {
                System.out.println("Move MenuItem clicked.");
                new MoveFrame(hex, component, hexBoard);
            });

        }
        unitsMenu.addActionListener(e -> {
            System.out.println("MenuItem clicked.");
            UnitsFrame unit = new UnitsFrame(hex, component);

        });
    }
}
