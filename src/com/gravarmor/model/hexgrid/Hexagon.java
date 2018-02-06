package com.gravarmor.model.hexgrid;

import com.gravarmor.model.units.Unit;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

public class Hexagon extends Polygon {
    
    protected Point centerPoint;
    protected Point[] vertices = new Point[6];
    //POSITION DANS LA GRILLE
    protected int j;
    protected int i;
    //CENTER POINT
    protected int x;
    protected int y;

    protected Unit unit;

    protected Hexagon[] neighborHexs;

    public Hexagon(int x, int y, int i, int j){
        this.setI(i);
        this.setJ(j);
        this.setCenterPoint(new Point(x, y));
    }


    public Point getCenterPoint() {
        return centerPoint;

    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Point[] getVertices() {
        return vertices;
    }

    public void setVertices(Point[] vertices) {
        this.vertices = vertices;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getX() {
        return (int)this.centerPoint.getX();
    }



    public int getY() {
        return (int)this.centerPoint.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Hexagon[] getNeighborHexs() {
        return neighborHexs;
    }

    public void setNeighborHexs(Hexagon[] neighborHexs) {
        this.neighborHexs = neighborHexs;
    }

    public void calculateVertices(){

        this.vertices[0] = new Point(this.getX(), this.getY()- Hexagrid.SIDELENGTH);
        this.vertices[1] = new Point(this.getX() + Hexagrid.DISTANCE, this.getY()- (Hexagrid.SIDELENGTH/2));
        this.vertices[2] = new Point(this.getX()+ Hexagrid.DISTANCE, this.getY()+ (Hexagrid.SIDELENGTH/2));
        this.vertices[3] = new Point(this.getX(), this.getY()+ Hexagrid.SIDELENGTH);
        this.vertices[4] = new Point(this.getX() - Hexagrid.DISTANCE , this.getY()+ (Hexagrid.SIDELENGTH/2));
        this.vertices[5] = new Point(this.getX() - Hexagrid.DISTANCE, this.getY()- (Hexagrid.SIDELENGTH/2));

    }

    public void drawHexagon(Graphics2D g2){
        Polygon poly = this.convertVerticesToPolygon();
        this.generateRandomColor();
        g2.setColor(this.generateRandomColor());
        g2.fillPolygon(poly);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(poly);
        g2.drawString(this.getI()+","+this.getJ(), this.getX() - 15, this.getY());


    }

    public Polygon convertVerticesToPolygon(){



        for (int i = 0; i < this.vertices.length; i++){
            this.addPoint((int)this.vertices[i].getX(), (int)this.vertices[i].getY());
        }


        return this;
    }


    public Color generateRandomColor() {
        Random random = new Random();
        Color colorHex;


        // Watter
        if (random.nextFloat() <0.15){
            colorHex = new Color(0x63DAFF);
        }
        // Floors
        else if ( random.nextFloat() >= 0.15 && random.nextFloat() < 0.9){
            colorHex = new Color(240, 219, 114, 229);
        }
        else{
            //Mountains
            colorHex = Color.GRAY;
        }

        return colorHex;
    }




}
