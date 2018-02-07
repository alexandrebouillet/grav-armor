package com.gravarmor.model.units;

import java.awt.*;

public class Unit {
    private int id;
    private int electronicWarfareValue;
    private String electronicWarfareColor;
    private int attack;
    private String weaponType;
    private int maximumRangeValue;
    private String maximumRangeColor;
    private Image unitPicture;
    private int movementPointsValue; // values : D --> 100, T --> 101 or numbers
    private String movementPointsColor;
    private String unitName;
    private int defenseValue;
    private String defenseColor;
    private String color;
    private String status; //dead or alive
    private String colorSpec;
    private int x;
    private int y;

    public Unit(int id, int electronicWarfareValue, String electronicWarfareColor, int attack, String weaponType, int maximumRangeValue, String maximumRangeColor, Image unitPicture, int movementPointsValue, String movementPointsColor, String unitName, int defenseValue, String defenseColor, String color, String status, String colorSpec, int x, int y) {
        this.id = id;
        this.electronicWarfareValue = electronicWarfareValue;
        this.electronicWarfareColor = electronicWarfareColor;
        this.attack = attack;
        this.weaponType = weaponType;
        this.maximumRangeValue = maximumRangeValue;
        this.maximumRangeColor = maximumRangeColor;
        this.unitPicture = unitPicture;
        this.movementPointsValue = movementPointsValue;
        this.movementPointsColor = movementPointsColor;
        this.unitName = unitName;
        this.defenseValue = defenseValue;
        this.defenseColor = defenseColor;
        this.color = color;
        this.status = status;
        this.colorSpec = colorSpec;
        this.x = x;
        this.y = y;
    }

    public Unit() {

    }

    public void place(Unit unit, int x, int y){
        unit.setX(x);
        unit.setY(y);
    }

    public void move(Unit unit, int x, int y){
        //TO DO : terrain key

        int movement = unit.getMovementPointsValue();
        int xUnit = unit.getX();
        int yUnit = unit.getY();
        int calc = Math.abs(x-xUnit)+(y-yUnit);

        if (calc<=movement){
            unit.setX(x);
            unit.setY(y);
        } else {
            System.out.println("Déplacement impossible !");
        }

    }

    public boolean detection (Unit attackUnit, Unit defenseUnit){
        boolean rep = false;
        int combatValues = 1;

        if (attackUnit.getElectronicWarfareValue()-combatValues>=0 &&
            Math.abs((attackUnit.getX()-attackUnit.getY())+(defenseUnit.getX()-defenseUnit.getY()))
            <=attackUnit.getMaximumRangeValue()){
            rep = true;
        }

        return rep;
    }

    public String fight(Unit attackUnit, Unit defenseUnit){
        int de = 12;
        double pourcent = 0;
        double rand;
        int [] range = {-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};

        //Attaque + EW + Bonus d’armement (si condition remplie) - Defense + EW + Valeur de combat case cible (sauf si cible en “free flight” ou volante)
        int calc = (attackUnit.getAttack()+attackUnit.getElectronicWarfareValue())- (defenseUnit.getDefenseValue()+defenseUnit.getElectronicWarfareValue());
        System.out.println("calc : "+calc);

        for (int i =0; i<=30; i++){
            if (range[i]==calc+de){
                pourcent= (double)i/(double)30;
            }
        }

        System.out.println("pour : "+pourcent);

        rand = Math.random();
        if (rand <= pourcent){
            System.out.println("hit : "+rand);
            defenseUnit.setStatus("dead");
        }
        else {
            System.out.println("try again : "+rand);
        }

        System.out.println("status : "+defenseUnit.getStatus());

        return defenseUnit.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElectronicWarfareValue() {
        return electronicWarfareValue;
    }

    public void setElectronicWarfareValue(int electronicWarfareValue) {
        this.electronicWarfareValue = electronicWarfareValue;
    }

    public String getElectronicWarfareColor() {
        return electronicWarfareColor;
    }

    public void setElectronicWarfareColor(String electronicWarfareColor) {
        this.electronicWarfareColor = electronicWarfareColor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getMaximumRangeValue() {
        return maximumRangeValue;
    }

    public void setMaximumRangeValue(int maximumRangeValue) {
        this.maximumRangeValue = maximumRangeValue;
    }

    public String getMaximumRangeColor() {
        return maximumRangeColor;
    }

    public void setMaximumRangeColor(String maximumRangeColor) {
        this.maximumRangeColor = maximumRangeColor;
    }

    public Image getUnitPicture() {
        return unitPicture;
    }

    public void setUnitPicture(Image unitPicture) {
        this.unitPicture = unitPicture;
    }

    public int getMovementPointsValue() {
        return movementPointsValue;
    }

    public void setMovementPointsValue(int movementPointsValue) {
        this.movementPointsValue = movementPointsValue;
    }

    public String getMovementPointsColor() {
        return movementPointsColor;
    }

    public void setMovementPointsColor(String movementPointsColor) {
        this.movementPointsColor = movementPointsColor;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    public String getDefenseColor() {
        return defenseColor;
    }

    public void setDefenseColor(String defenseColor) {
        this.defenseColor = defenseColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColorSpec() {
        return colorSpec;
    }

    public void setColorSpec(String colorSpec) {
        this.colorSpec = colorSpec;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
