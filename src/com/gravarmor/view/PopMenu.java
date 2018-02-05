package com.gravarmor.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopMenu extends JPopupMenu {


    public PopMenu(){
        JMenuItem unitsMenu = new JMenuItem("Placer une unités");
        this.add(unitsMenu);

        unitsMenu.addActionListener(e -> {
            System.out.println("MenuItem clicked.");
            new UnitsFrame();
        });
    }
}
