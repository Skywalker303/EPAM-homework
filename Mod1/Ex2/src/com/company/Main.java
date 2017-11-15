package com.company;

public class Main {

    public static void main(String[] args) {
        int i = 99;
        double[] a = new double[100];
        double E = 0.01;

        for (; ; i--) {
            a[i] = (1 / Math.pow(i + 1, 2));
            System.out.println("a[" + i + "] = " + a[i]);
            if (a[i] > E) {
                System.out.println("Наименьший номер элемента = "+i);
                return;
            }
        }
    }
}
