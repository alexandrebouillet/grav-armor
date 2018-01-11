package com.gravarmor;

import com.gravarmor.model.units.Tank;
import com.gravarmor.model.units.Plane;
import com.gravarmor.model.units.Infantry;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        //tanks
        Tank tank = new Tank(1, 3, "black", 3, "Gatling Lasers", 2,
                "black",getImage("data\\aza3 red.png"),5, "black", "Aza3",
                3, "black","red", "alive", "blanc", -1, -1);

        tank.place(tank, 9, 5);

        //planes
        Plane plane = new Plane(2, 4, "black", 5, "Gatling Lasers", 3,
                "black",getImage("data\\fl6 blue.png"),101, "black", "FL6",
                8, "white","blue", "alive", "black", -1, -1);

        plane.place(plane, 10,10);
        //infantries
        Infantry infantry = new Infantry(3, 3, "white", 2, "Missiles", 3,
                "black",getImage("data\\ainf blue.png"),2, "yellow", "A-INF",
                7, "black","blue", "alive", "black", -1, -1);

        infantry.place(infantry, 10,10);

        tank.move(tank, 10, 9);
        if (infantry.getX()==tank.getX() && infantry.getY()==tank.getY()){

        }


        // TO DO détecter tout le monde
        if(tank.detection(tank, plane)){
            tank.fight(tank,plane);
        }

    }

    public static Image getImage(String path){
        Image image = null;
        try {
            File url = new File(path);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
