package com.company;

public class Clip {
    private String id;
    private String manufacturer;
    private String color;
    private int size;
    private double cost = 25.50;

    public Clip(String id, String manufacturer, String color, int size, double cost) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.size = size;
        this.cost = cost;
    }

    public Clip() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
