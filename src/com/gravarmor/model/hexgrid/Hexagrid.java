package com.gravarmor.model.hexgrid;

import java.awt.*;
import java.util.ArrayList;

public class Hexagrid {

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

        A OPTIMISER !!!
     */
    public Hexagon getNearestHex(int x, int y){
        float q = (float)( x * Math.sqrt(3)/3 - y / 3) / SIDELENGTH;
        float r = 2f/3f * y / SIDELENGTH;

        int cx = (int) q;
        int cz = (int) r;
        int cy = -cx-cz;
        int col = cx + (cz + (cz&1)) /2;
        int row = cz;

        System.out.println(" col :" + col +"- row :" + row);
        return this.board[row][col];
    }
    /*
    Renvoi tous les hexagones voisons d'une certaine distance

    A REVOIR !!

     */ public ArrayList<Hexagon> getNeighborHexs(Hexagon hex, int distance){

         ArrayList<Hexagon> neighborHexs = new ArrayList<>();

         for (int i = hex.getI() - distance; i<= hex.getI() + distance; i++){
            for (int j = hex.getJ() - distance; j <= hex.getJ() + distance; j++ ){
                neighborHexs.add(this.board[i][j]);
                System.out.println(this.board[i][j].getI() +"-"+ this.board[i][j].getJ() );
            }
         }

        return neighborHexs;
    }

}
