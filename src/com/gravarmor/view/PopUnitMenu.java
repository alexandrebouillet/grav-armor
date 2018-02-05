package com.gravarmor.view;

import javax.swing.*;

public class PopUnitMenu extends JPopupMenu {

    public PopUnitMenu(){
        JMenuItem moveMenu = new JMenuItem("Se déplacer");
        JMenuItem fireMenu = new JMenuItem("Attaquer");
        this.add(moveMenu);
        this.add(fireMenu);

        moveMenu.addActionListener(e -> {
            System.out.println("MoveMenu clicked.");
        });
        fireMenu.addActionListener(e -> {
            System.out.println("FireMenu clicked.");
        });
    }


}
