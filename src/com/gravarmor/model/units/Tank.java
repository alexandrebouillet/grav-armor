package com.gravarmor.model.units;

import java.awt.*;

public class Tank extends Unit {
    public Tank(int id, int electronicWarfareValue, String electronicWarfareColor, int attack, String weaponType, int maximumRangeValue, String maximumRangeColor, Image unitPicture, int movementPointsValue, String movementPointsColor, String unitName, int defenseValue, String defenseColor, String color, String status, String colorSpec, int x, int y) {
        super(id, electronicWarfareValue, electronicWarfareColor, attack, weaponType, maximumRangeValue, maximumRangeColor, unitPicture, movementPointsValue, movementPointsColor, unitName, defenseValue, defenseColor, color, status, colorSpec, x, y);
    }
}
