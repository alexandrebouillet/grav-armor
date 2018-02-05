package com.gravarmor.view;

import com.gravarmor.controller.HexGridController;
import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.hexgrid.Hexagrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HexGridPanel extends JPanel {

    //mouse variables here
    //Point mPt = new Point(0,0);

    private Hexagrid hexBoard = new Hexagrid();

    public HexGridPanel()
    {
        HexGridController hexClick = new HexGridController(this.hexBoard);
        addMouseListener(hexClick);

    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g2);
        Hexagon[][] hex = this.hexBoard.getBoard();
        for (int i=0;i< this.hexBoard.getGridMaxI();i++) {
            for (int j=0;j< this.hexBoard.getGridMaxJ();j++) {
                hex[i][j].drawHexagon(g2);
            }
        }
    }
}
