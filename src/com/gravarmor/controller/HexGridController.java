package com.gravarmor.controller;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.hexgrid.Hexagrid;

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
        Point px = new Point(x,y);
        Hexagon hex;
        hex = this.hexBoard.getClickedHex(px);
        System.out.println(hex.getI() +" - " + hex.getJ());

    }

}
