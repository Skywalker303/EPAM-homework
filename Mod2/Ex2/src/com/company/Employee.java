package com.company;

public class Employee {

    private Integer id;
    private String firstname;
    private String lastName;
    private String department;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    enum Stationery{
        Pen,Pencil,Paper,Clip;
        Pen pen = new Pen();
        Pencil pencil = new Pencil();
        Paper paper = new Paper();
        Clip clip = new Clip();

        public double getCost(){
             double gc = pen.getCost()+pencil.getCost()+paper.getCost()+clip.getCost() ;
            return gc;
        }

    }



}
