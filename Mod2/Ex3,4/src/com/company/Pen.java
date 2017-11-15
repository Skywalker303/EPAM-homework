package com.company;

public class Pen extends WritingThing implements Comparable{
    private Integer id = 2;
    private String manufacturer;
    private String color;
    private boolean ball;
    private double cost = 100.00;

    public Pen(Integer id, String manufacturer, String color, boolean ball, double cost) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.ball = ball;
        this.cost = cost;
    }

    public Pen() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isBall() {
        return ball;
    }

    public void setBall(boolean ball) {
        this.ball = ball;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
