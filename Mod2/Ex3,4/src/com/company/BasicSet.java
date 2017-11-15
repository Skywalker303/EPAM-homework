package com.company;

public class BasicSet {
    BasicSet[] concat(Notebook[] notebooks,Pencil[] pencils, Pen[] pens) {
        int aLen = notebooks.length;
        int bLen = pencils.length;
        int cLen = pens.length;
        BasicSet[] M = new BasicSet[aLen + bLen + cLen];
        System.arraycopy(notebooks, 0, M, 0, aLen);
        System.arraycopy(pens, 0, M, aLen, bLen);
        System.arraycopy(pencils, 0, M, 2*bLen, cLen);
        return M;
    }
}

