package com.gravarmor.model.hexgrid;

import java.awt.*;

public class Hexagrid {

    public static int SIDELENGTH =35;
    public static int DISTANCE = 30;
    //Nombre de ligne
    protected int gridMaxI = 17;
    //Nombre de colonne
    protected int gridMaxJ = 25;

    protected Hexagon[][] board = new Hexagon[gridMaxI][gridMaxJ];

    public Hexagrid() {
        board[0][0] = new Hexagon(2, 30, 0, 0);

        for (int i = 0; i < gridMaxI; i++){
            for (int j = 0; j < gridMaxJ; j++) {
                board[i][j] = new Hexagon((board[0][0].getX() + (i % 2) * DISTANCE + (j * 2 * DISTANCE)),(board[0][0].getY() + (i * ((3 * SIDELENGTH) / 2))), i, j);
                board[i][j].calculateVertices();
                System.out.println("X: " + board[i][j].getX() +"- Y:" + board[i][j].getY() + "- J:"+ j);
            }
        }
    }

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

}
