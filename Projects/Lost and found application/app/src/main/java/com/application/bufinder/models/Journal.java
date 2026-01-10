package com.application.bufinder.models;

public class Journal {
    private String Item;
    private String Sub;
    private String Brand;
    private String Color;

    public Journal() {
    }

    public Journal(String item, String sub, String brand, String color) {
        Item = item;
        Sub = sub;
        Brand = brand;
        Color = color;
    }


    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getSub() {
        return Sub;
    }

    public void setSub(String sub) {
        Sub = sub;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}