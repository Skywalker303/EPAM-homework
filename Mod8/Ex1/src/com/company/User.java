package com.company;

public class User {
    private int id;
    protected String BusinessArea;
    protected  int YearsOnMarket;
    protected double PotentialMarketShare;
    protected String TagsAboutProductSpecific;
    protected String Location;

    public User (int i,String BA, int YOM, double PoMS, String TAPS, String loc){
        id = i;
        BusinessArea = BA;
        YearsOnMarket = YOM;
        PotentialMarketShare = PoMS;
        TagsAboutProductSpecific = TAPS;
        Location = loc;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessArea() {
        return BusinessArea;
    }

    public void setBusinessArea(String businessArea) {
        BusinessArea = businessArea;
    }

    public int getYearsOnMarket() {
        return YearsOnMarket;
    }

    public void setYearsOnMarket(int yearsOnMarket) {
        YearsOnMarket = yearsOnMarket;
    }

    public double getPotentialMarketShare() {
        return PotentialMarketShare;
    }

    public void setPotentialMarketShare(double potentialMarketShare) {
        PotentialMarketShare = potentialMarketShare;
    }

    public String getTagsAboutProductSpecific() {
        return TagsAboutProductSpecific;
    }

    public void setTagsAboutProductSpecific(String tagsAboutProductSpecific) {
        TagsAboutProductSpecific = tagsAboutProductSpecific;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "id: "+ id
                + ", BusinessArea: "+BusinessArea
                + ", YearsOnMarket: "+YearsOnMarket
                + ", PotentialMarketShare: "+PotentialMarketShare
                + ", TagsAboutProductSecific: " + TagsAboutProductSpecific
                + ", Location: "+Location;
    }

}
