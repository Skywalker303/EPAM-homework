package com.company;

public  class WritingThing extends BasicSet {
    private int id;
    private String manufacturer;
    private String color;
    private boolean lead;
    private double cost;

    public WritingThing(Integer id, String manufacturer, String color, boolean lead, double cost) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.lead = lead;
        this.cost = cost;
    }

    public WritingThing() {

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

    WritingThing[] concat(Pen[] pens, Pencil[] pencils) {
        int aLen = pens.length;
        int bLen = pencils.length;
        WritingThing[] L= new WritingThing[aLen+bLen];
        System.arraycopy(pens, 0, L, 0, aLen);
        System.arraycopy(pencils, 0, L, aLen, bLen);
        return L;
    }

    public WritingThing[] sort(WritingThing [] writingThing) {
        if (writingThing[id].getCost()>writingThing[id+1].getCost()){
            WritingThing t = writingThing[id+1];
            writingThing[id+1]=writingThing[id];
            writingThing[id] = t;
            return writingThing;
        }
        else{
            return writingThing;
        }
    }
}
