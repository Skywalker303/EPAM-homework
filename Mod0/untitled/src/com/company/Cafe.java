package com.company;


import java.util.HashMap;
import java.util.Map;


class Cafe
{//объявление переменной - количество саженцев
    static int col = 0;
    public static void main(String args[]) throws InterruptedException
    {


//проверим сколько параметров завели, если не 1, то ругаемся и выходим
        if (args.length != 1)
        { System.out.println("Должен быть заведен один агрумент!");
            System.exit(0);
        };

//проверим является ли параметр числом, если нет, то ругаемся и выходим
        try
        {
//преобразуем строковые аргументы к int
            col = Integer.parseInt(args[0]);

        }
        catch (NumberFormatException e)
        {
            System.out.println("Агрумент введен неправильно!");
            System.exit(0);
        }
//проверка на отрицательные числа
        if (col < 0 )
        { System.out.println("Аргумент должен быть положительным числом!");
            System.exit(0);
        };


        try {
            System.out.println("Количество клиентов: " + col);
            System.out.println();

            int dish = 3;

            new Cook(col+1, dish);
            new Waitress(col+1, dish);
            new Customer(col+1, dish);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Cafe cf = new Cafe();
        cf.fillINhm();

    }
    public void fillINhm() {
        Map<Integer, String> hm = new HashMap<>();
        int colcounter = col;// счетчик клиентов, не получивших заказ
        hm.put(1, "dish1");
        hm.put(2, "");
        hm.put(3, "");
        Object[] b = hm.keySet().toArray();

        if (!hm.values().contains("dish2") && !hm.values().contains("dish3"))//проверка на кооличество блюд, полученное клиентом {
            for (int i = 0; i < hm.size() - 1; i++) {
                if (hm.entrySet().size() != col) // если количество получивших заказ клиентов не соответствует кол-ву пришедших
                {
                    colcounter = col--;
                }
                while(colcounter != 0) {
                    if (b[i].hashCode() < b[i + 1].hashCode()) {
                        hm.put(i + 1, "dish1");
                    }
                }
            }
            hm.put(hm.size(), "dish1");// "Костыль" по причине ArrayIndexOutOfBoundsEcxception
            for (int j = 0; j < hm.size() - 1; j++) {
                if (hm.entrySet().size() != col) {
                            colcounter = col--;
                }
                if (colcounter != 0) {
                    if (b[j].hashCode() < b[j + 1].hashCode()) {
                                hm.put(j + 1, "dish2");
                            }
                        }
                    }
                    hm.put(hm.size(), "dish2");// "Костыль" по причине ArrayIndexOutOfBoundsEcxception
                    if (!hm.values().contains("dish3")) {
                        for (int i = 0; i < hm.size() - 1; i++) {

                            if (b[i].hashCode() < b[i + 1].hashCode()) {
                                hm.put(i + 1, "dish3");
                            }
                        }
                        hm.put(hm.size(), "dish3");
                    }
                }
            }


