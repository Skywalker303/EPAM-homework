package com.company;

public class Paper {
    private String id;
    private String manufacturer;
    private String color;
    private String format;
    private double cost = 400.50;

    public Paper(String id, String manufacturer, String color, String format, double cost) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.format = format;
        this.cost = cost;
    }

    public Paper() {

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
