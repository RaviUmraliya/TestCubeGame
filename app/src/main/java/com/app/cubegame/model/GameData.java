package com.app.cubegame.model;

public class GameData {


    public int id;
    public String strColor;
    public boolean isSelected = false;

    public GameData() {
    }

    public GameData(int id, String strColor, boolean isSelected) {
        this.id = id;
        this.strColor = strColor;
        this.isSelected = isSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrColor() {
        return strColor;
    }

    public void setStrColor(String strColor) {
        this.strColor = strColor;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
