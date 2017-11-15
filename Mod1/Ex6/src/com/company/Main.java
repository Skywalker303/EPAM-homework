package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String l = "After change";
        List<String> arrayList = new ArrayList<>();
        WritingInNotebook writingInNotebook = new WritingInNotebook();
        arrayList.add(writingInNotebook.getStr());
        System.out.println(arrayList);
        arrayList.set(0,l);
        System.out.println(arrayList);
        arrayList.remove(writingInNotebook.getStr());
        if (arrayList==null){
            System.out.println(Collections.EMPTY_LIST);
        }

    }

    private static class WritingInNotebook{
        String str = "Before change";

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

    }

    private class Notebook{


    }
}
