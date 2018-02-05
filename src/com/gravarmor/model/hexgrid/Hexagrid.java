package com.gravarmor.model.hexgrid;

import java.awt.*;
import java.util.ArrayList;

public class Hexagrid extends Polygon{

    public static int SIDELENGTH =35;
    public static int DISTANCE = 30;
    //Nombre de ligne
    protected int gridMaxI = 18;
    //Nombre de colonne
    protected int gridMaxJ = 24;

    protected Hexagon[][] board = new Hexagon[gridMaxI][gridMaxJ];

    public Hexagrid() {
        board[0][0] = new Hexagon(0, 0, 0, 0);

        for (int i = 0; i < gridMaxI; i++){
            for (int j = 0; j < gridMaxJ; j++) {
                board[i][j] = new Hexagon((board[0][0].getX() + (i % 2) * DISTANCE + (j * 2 * DISTANCE)),(board[0][0].getY() + (i * ((3 * SIDELENGTH) / 2))), i, j);
                board[i][j].calculateVertices();
            }
        }
        for (int i = 1; i < gridMaxI-1; i++){
            for (int j = 1; j < gridMaxJ-1; j++) {
                System.out.println(i +" : "+ j);
                this.calculateNeighborHexs(board[i][j]);
            }
        }
    }
    /*
    GETTERS/SETTERS
     */
    public int getGridMaxI() {
        return gridMaxI;
    }

    public void setGridMaxI(int gridMaxI) {
        this.gridMaxI = gridMaxI;
    }

    public int getGridMaxJ() {
        return gridMaxJ;
    }

    public void setGridMaxJ(int gridMaxJ) {
        this.gridMaxJ = gridMaxJ;
    }

    public Hexagon[][] getBoard() {
        return board;
    }

    public void setBoard(Hexagon[][] board) {
        this.board = board;
    }
    /*
     FUNCTION
    */

    /*
        Calcul de l'hexagone le plus proche en cliquant sur la map
     */
    public Hexagon getClickedHex(Point px){

        for (int i = 0; i < gridMaxI; i++){
            for (int j = 0; j < gridMaxJ; j++) {
                if(board[i][j].contains(px)){
                    return board[i][j];
                }
            }
        }
        return board[0][0];
    }
    /*
    Renvoi tous les hexagones voisons
     */ public Hexagon[] calculateNeighborHexs(Hexagon hex){


         Hexagon[] neighborHexs = {
                 board[hex.getI()+1][hex.getJ()],
                 board[hex.getI()+1][hex.getJ()-1],
                 board[hex.getI()][hex.getJ()-1],
                 board[hex.getI()-1][hex.getJ()],
                 board[hex.getI()-1][hex.getJ()-1],
                 board[hex.getI()][hex.getJ()+1],
         };
        hex.setNeighborHexs(neighborHexs);


        return hex.getNeighborHexs();
    }


}
