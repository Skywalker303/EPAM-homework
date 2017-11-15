package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Employee.Stationery> al = new ArrayList<>();
    public static void main(String[] args) {

    al.add(Employee.Stationery.Clip);
    al.add(Employee.Stationery.Paper);
    al.add(Employee.Stationery.Pen);
    al.add(Employee.Stationery.Pencil);
    System.out.println(buy());
    }
    public static double buy() {
        double sum = 0;
        for (Employee.Stationery s : al) {
            sum = s.getCost();
        }
        return sum;
    }
}
