package com.gravarmor.view;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.hexgrid.Hexagrid;
import com.gravarmor.model.units.Infantry;
import com.gravarmor.model.units.Plane;
import com.gravarmor.model.units.Tank;
import com.gravarmor.model.units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MoveFrame extends JFrame{

    private Hexagon[] hexRange;

    private Hexagrid hexBoard;

    public MoveFrame(Hexagon hex, Component component, Hexagrid hexboard) {


        this.hexBoard = hexboard;
        System.out.println(hex.getUnit().getMovementPointsValue());
        this.hexRange = this.hexBoard.getMultipleNeighborsHexs(hex, hex.getUnit().getMovementPointsValue());
        this.setTitle("Bouger !");

        setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        JComboBox move = new JComboBox();

        for (Hexagon hexR: hexRange) {
            if (hexR != null){
                move.addItem(hexR.getI()+","+hexR.getJ());
            }
        }

        move.setSize(125,50);
        move.setBounds(25, 25, 125, 25);

        JButton btn = new JButton();
        btn.setText("Bouger !");
        btn.setSize(125,50);
        btn.setBounds(175, 25, 125, 25);

        this.add(move);
        this.add(btn);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        this.setSize( 325, 100);
        this.setResizable(false);
        this.setLocationRelativeTo( null );
        this.setLayout(null);
        this.setVisible(true);

        btn.addActionListener(e -> {
            System.out.println("Button move clicked.");

            Object moveSelected = move.getSelectedItem();
            for (Hexagon hexR: this.hexRange) {
                String pos = new String(hexR.getI()+","+hexR.getJ());
                if (pos.equals(moveSelected)){
                    hexR.setUnit(hex.getUnit());
                    hex.setUnit(null);
                }
            }
            this.setVisible(false);
        });

    }
}
