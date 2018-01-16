package com.gravarmor.model.hexgrid;

import java.awt.*;
import java.util.ArrayList;

public class Hexagrid extends Polygon{

    public static int SIDELENGTH =35;
    public static int DISTANCE = 30;
    //Nombre de ligne
    protected int gridMaxI = 17;
    //Nombre de colonne
    protected int gridMaxJ = 23;

    protected Hexagon[][] board = new Hexagon[gridMaxI][gridMaxJ];

    public Hexagrid() {
        board[0][0] = new Hexagon(7, 30, 0, 0);

        for (int i = 0; i < gridMaxI; i++){
            for (int j = 0; j < gridMaxJ; j++) {
                board[i][j] = new Hexagon((board[0][0].getX() + (i % 2) * DISTANCE + (j * 2 * DISTANCE)),(board[0][0].getY() + (i * ((3 * SIDELENGTH) / 2))), i, j);
                board[i][j].calculateVertices();
                System.out.println("X: " + board[i][j].getX() +"- Y:" + board[i][j].getY() + "- J:"+ j);
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
     */ public Hexagon[] getNeighborHexs(Hexagon hex){


         Hexagon[] neighborHexs = {
                 board[hex.getI()+1][hex.getJ()],
                 board[hex.getI()+1][hex.getJ()-1],
                 board[hex.getI()][hex.getJ()-1],
                 board[hex.getI()-1][hex.getJ()],
                 board[hex.getI()-1][hex.getJ()+1],
                 board[hex.getI()][hex.getJ()+1],
         };

        return neighborHexs;
    }

}
