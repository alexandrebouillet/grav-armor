package com.gravarmor.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopMenu extends JPopupMenu {


    public PopMenu(){
        JMenuItem unitsMenu = new JMenuItem("Placer une unités");
        JMenuItem turnMenu = new JMenuItem("Finir le tour");
        this.add(unitsMenu);
        this.add(turnMenu);

        unitsMenu.addActionListener(e -> {
            System.out.println("MenuItem clicked.");
            new UnitsFrame();
        });
    }
}
