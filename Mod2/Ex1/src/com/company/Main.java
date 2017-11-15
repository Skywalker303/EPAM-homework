package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Pen p1 = new Pen();
        Pen p2 = new Pen();

        p1.setId(100);
        p2.setId(100);

        Set pens = new HashSet();
        pens.add(p1);
        pens.add(p2);
        Iterator iterator = pens.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
