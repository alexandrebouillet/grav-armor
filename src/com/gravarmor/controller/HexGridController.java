package com.gravarmor.controller;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.hexgrid.Hexagrid;
import com.gravarmor.view.PopHexMenu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HexGridController extends MouseAdapter {

    private Hexagrid hexBoard;

    public HexGridController(Hexagrid hexBoard){
        this.hexBoard = hexBoard;
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x +" - " + y);
        Point px = new Point(x,y);

        Hexagon hex;
        hex = this.hexBoard.getClickedHex(px);
        System.out.println(hex.getI() +" - " + hex.getJ());

        //Clique gauche
        if(e.getModifiers() == MouseEvent.BUTTON1_MASK){
            System.out.println("CLIQUE GAUCHE");
        }
        if(e.getModifiers() == MouseEvent.BUTTON3_MASK){
            System.out.println("CLIQUE DROITE");

            PopHexMenu popupMenu = new PopHexMenu(hex, e.getComponent(), this.hexBoard);
            popupMenu.show(e.getComponent(), x, y);

        }
    }

}
