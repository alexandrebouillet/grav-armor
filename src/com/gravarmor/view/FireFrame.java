package com.gravarmor.view;

import com.gravarmor.model.hexgrid.Hexagon;
import com.gravarmor.model.hexgrid.Hexagrid;
import com.gravarmor.model.units.Unit;
import sun.management.counter.Units;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FireFrame extends JFrame {

    private Hexagon[] hexRange;

    private Hexagrid hexBoard;

    private ArrayList<Unit> unitsArray = new ArrayList<>();

    public FireFrame(Hexagon hex, Component component, Hexagrid hexboard) {

        this.hexBoard = hexboard;
        this.hexRange = this.hexBoard.getMultipleNeighborsHexs(hex, hex.getUnit().getMaximumRangeValue());
        this.unitsArray = this.getUnitOnHex(hexRange);

        this.setTitle("Attaquer !");

        this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        JComboBox fireRange = new JComboBox();

        for (Unit unit: this.unitsArray) {
            fireRange.addItem(unit.getUnitName());
        }

        fireRange.setSize(125,50);
        fireRange.setBounds(25, 25, 125, 25);

        JButton btn = new JButton();
        btn.setText("OK");
        btn.setSize(125,50);
        btn.setBounds(175, 25, 125, 25);
        if(fireRange.getItemCount() > 0 ){
            this.add(fireRange);
        }else{
            JLabel noUnit = new JLabel("Aucun unité à votre porté");
            this.add(noUnit);
        }

        this.add(btn);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        this.setSize( 325, 100);
        this.setResizable(false);
        this.setLocationRelativeTo( null );
        this.setLayout(null);
        this.setVisible(true);

        btn.addActionListener(e -> {
            System.out.println("Button Attaquer clicked.");

            Object unitSelected = fireRange.getSelectedItem();
            for (Unit unitCheck: this.unitsArray) {
                if (unitCheck.getUnitName()== unitSelected){
                    hex.getUnit().fight(hex.getUnit(), unitCheck);
                }
            }
            this.setVisible(false);
        });

    }

    private ArrayList<Unit> getUnitOnHex(Hexagon[] hexRange){
        ArrayList<Unit> unitArray = new ArrayList<>();
        for (Hexagon hex: hexRange) {
            if(hex != null){
                Unit unit = hex.getUnit();
                if(unit != null){
                    unitArray.add(unit);
                }
            }
        }
        return unitArray;
    }

}
