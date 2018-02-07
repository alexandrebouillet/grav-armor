package com.gravarmor.model.hexgrid;

import com.gravarmor.model.units.Unit;

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

    public int calculHex(int range)
    {
        int compteur = range;
        int ret = 0;

        for(int i = 0; i < range; i++)
        {
            ret += compteur*6;
            compteur--;
        }

        return ret;
    }


    /*
    Renvoi tous les hexagones voisons
     */
    public Hexagon[] getMultipleNeighborsHexs(Hexagon hex, int range){

        int compteur = 0;
        int maxMid = range * 2 + 1;
        int maxTopBot = range + 1;
        int initRange = -(range);
        int xHex = hex.getI();
        int nbHex = calculHex(range);
        int doubleHex = 0;
        int incDoubHex = 0;


        Hexagon[] tabHex = new Hexagon[nbHex];

        if(xHex%2 == 0)
        {
            for(int i = 0; i < maxTopBot; i++)
            {
                //Si c'est 0 alors on calcul la partie du milieu
                if(i == 0)
                {
                    for(int incMid = 0; incMid < maxMid; incMid++)
                    {
                        tabHex[compteur] = board[hex.getI()][hex.getJ()+initRange+incMid];
                        compteur++;
                        doubleHex++;
                    }
                }
                else
                {
                    for(int incHex = 0; incHex < maxMid-i; incHex++)
                    {
                        //Pour avoir le coter haut des voisins hex
                        tabHex[compteur] = board[hex.getI()-i][hex.getJ()+initRange+incHex+incDoubHex];
                        //Pour avoir le coter bas des voisins hex
                        tabHex[compteur] = board[hex.getI()+i][hex.getJ()+initRange+incHex+incDoubHex];
                        compteur++;
                    }
                    doubleHex++;
                    if(doubleHex == 2){doubleHex = 0; incDoubHex++;}

                }


            }

        }
        else
        {
            for(int i = 0; i < maxTopBot; i++)
            {
                //Si c'est 0 alors on calcul la partie du milieu
                if(i == 0)
                {
                    for(int incMid = 0; incMid < maxMid; incMid++)
                    {
                        tabHex[compteur] = board[hex.getI()][hex.getJ()-initRange-incMid];
                        compteur++;
                        doubleHex++;
                    }
                }
                else
                {
                    for(int incHex = 0; incHex < maxMid-i; incHex++)
                    {
                        //Pour avoir le coter haut des voisins hex
                        tabHex[compteur] = board[hex.getI()-i][hex.getJ()-initRange-incHex-incDoubHex];
                        //Pour avoir le coter bas des voisins hex
                        tabHex[compteur] = board[hex.getI()+i][hex.getJ()-initRange-incHex-incDoubHex];
                        compteur++;
                    }
                    doubleHex++;
                    if(doubleHex == 2){doubleHex = 0; incDoubHex++;}
                }


            }

        }


        hex.setNeighborHexs(tabHex);

        return hex.getNeighborHexs();
    }

    public int calculHex(int range)
    {
        int compteur = range;
        int ret = 0;

        for(int i = 0; i < range; i++)
        {
            ret += compteur*6;
            compteur--;
        }

        return ret;
    }


    /*
    Renvoi tous les hexagones voisons
     */
    public Hexagon[] getMultipleNeighborsHexs(Hexagon hex, int range){

        int compteur = 0;
        int maxMid = range * 2 + 1;
        int maxTopBot = range + 1;
        int initRange = -(range);
        int xHex = hex.getI();
        int nbHex = calculHex(range)+1;
        int doubleHex = 0;
        int incDoubHex = 0;


        Hexagon[] tabHex = new Hexagon[nbHex];

        if(xHex%2 == 0)
        {
            for(int i = 0; i < maxTopBot; i++)
            {
                //Si c'est 0 alors on calcul la partie du milieu
                if(i == 0)
                {
                    for(int incMid = 0; incMid < maxMid; incMid++)
                    {
                        tabHex[compteur] = board[hex.getI()][hex.getJ()+initRange+incMid];
                        System.out.println("tabHex i 0 "+tabHex[compteur].getI()+" tabHex j 0 "+tabHex[compteur].getJ());

                        compteur++;
                        doubleHex++;
                    }
                }
                else
                {
                    for(int incHex = 0; incHex < maxMid-i; incHex++)
                    {
                        //Pour avoir le coter haut des voisins hex
                        tabHex[compteur] = board[hex.getI()-i][hex.getJ()+initRange+incHex+incDoubHex];
                        System.out.println("tabHex i 1 "+tabHex[compteur].getI()+" tabHex j 1 "+tabHex[compteur].getJ());
                        compteur++;

                        //Pour avoir le coter bas des voisins hex
                        tabHex[compteur] = board[hex.getI()+i][hex.getJ()+initRange+incHex+incDoubHex];
                        System.out.println("tabHex i 1 "+tabHex[compteur].getI()+" tabHex j 1 "+tabHex[compteur].getJ());
                        compteur++;
                    }
                    doubleHex++;
                    if(doubleHex == 2){doubleHex = 0; incDoubHex++;}

                }


            }

        }
        else
        {
            for(int i = 0; i < maxTopBot; i++)
            {
                //Si c'est 0 alors on calcul la partie du milieu
                if(i == 0)
                {
                    for(int incMid = 0; incMid < maxMid; incMid++)
                    {
                        tabHex[compteur] = board[hex.getI()][hex.getJ()-initRange-incMid];
                        System.out.println("tabHex i 2 "+tabHex[compteur].getI()+" tabHex j 2 "+tabHex[compteur].getJ());

                        compteur++;
                        doubleHex++;
                    }
                }
                else
                {
                    for(int incHex = 0; incHex < maxMid-i; incHex++)
                    {
                        //Pour avoir le coter haut des voisins hex
                        tabHex[compteur] = board[hex.getI()-i][hex.getJ()-initRange-incHex-incDoubHex];
                        System.out.println("tabHex i 3 "+tabHex[compteur].getI()+" tabHex j 3 "+tabHex[compteur].getJ());
                        compteur++;

                        //Pour avoir le coter bas des voisins hex
                        tabHex[compteur] = board[hex.getI()+i][hex.getJ()-initRange-incHex-incDoubHex];
                        System.out.println("tabHex i 3 "+tabHex[compteur].getI()+" tabHex j 3 "+tabHex[compteur].getJ());
                        compteur++;
                    }
                    doubleHex++;
                    if(doubleHex == 2){doubleHex = 0; incDoubHex++;}
                }


            }

        }


        hex.setNeighborHexs(tabHex);

        return hex.getNeighborHexs();
    }
}
