package com.gravarmor.view;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.units.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopHexMenu extends JPopupMenu {


    public PopHexMenu(Hexagon hex, Component component){
        JMenuItem unitsMenu = new JMenuItem("Placer une unités");
        JMenuItem turnMenu = new JMenuItem("Finir le tour");

        this.add(unitsMenu);
        this.add(turnMenu);

        unitsMenu.addActionListener(e -> {
            System.out.println("MenuItem clicked.");
            UnitsFrame unit = new UnitsFrame(hex, component);

        });
    }
}
