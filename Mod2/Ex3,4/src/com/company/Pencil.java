package com.company;

public class Pencil extends WritingThing implements Comparable{
    private Integer id = 1;
    private String manufacturer;
    private String color;
    private boolean lead;
    private double cost = 80.00;

    public Pencil(Integer id, String manufacturer, String color, boolean lead, double cost) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.lead = lead;
        this.cost = cost;
    }

    public Pencil() {

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

    public boolean isLead() {
        return lead;
    }

    public void setLead(boolean lead) {
        this.lead = lead;
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
