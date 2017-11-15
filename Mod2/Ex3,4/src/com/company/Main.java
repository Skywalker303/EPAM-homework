package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Paper[] papers;
        WritingThing[] wthings;
        Paper paper = new Paper();
        WritingThing writingThing = new WritingThing();

        Notebook[] notebooks = new Notebook[10];
        Notebook nb = new Notebook();
        for (int i = 0; i <= notebooks.length - 1; i++) {
            notebooks[i] = nb;
        }

        Notepad[] notepads = new Notepad[10];
        Notepad np = new Notepad();
        for (int i = 0; i <= notepads.length - 1; i++) {
            notepads[i] = np;
        }
        papers = paper.concat(notebooks, notepads);

        Pen pn = new Pen();
        Pen[] pens = new Pen[10];
        for (int i = 0; i <= pens.length - 1; i++) {
            pens[i] = pn;
        }
        Pencil pc = new Pencil();
        Pencil[] pencils = new Pencil[10];
        for (int i = 0; i <= pencils.length - 1; i++) {
            pencils[i] = pc;
        }
        wthings = writingThing.concat(pens, pencils);

        Arrays.sort(wthings);
        Arrays.sort(papers);

        for (int i = 0; i < papers.length; i++) {
            System.out.println(papers[i]);
        }
        for (int j = 0; j < wthings.length; j++) {
            System.out.println(wthings[j]);
            Arrays.sort(wthings[j].sort(wthings));
        }

       BasicSet bs = new BasicSet();
       BasicSet [] basicSet;
       basicSet = bs.concat(notebooks,pencils,pens);

        System.out.println("");
        for (int j = 0; j < basicSet.length; j++) {
            System.out.println(basicSet[j]);
        }
    }
}

