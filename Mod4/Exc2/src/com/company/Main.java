package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static String fileNamein = "C:\\Users\\norri\\IdeaProjects\\Mod3\\Ex3\\src\\com\\company\\Main.java";
    private static String fileNameout = "C:\\Users\\norri\\IdeaProjects\\Mod4\\Exc2\\KWords.txt";
   static List<String> keyWords = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        try (FileReader fileReader = new FileReader(fileNamein);
             FileWriter fileWriter = new FileWriter(new File(fileNameout))) {
            Counter(fileReader, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Counter(FileReader fileReader, FileWriter fileWriter)
            throws IOException {

        keyWords.add("append");
        keyWords.add("catch");
        keyWords.add("for");
        keyWords.add("else");
        keyWords.add("java");
        keyWords.add("if");
        keyWords.add("new");
        keyWords.add("package");
        keyWords.add("private");
        keyWords.add("public");
        keyWords.add("return");
        keyWords.add("static");
        keyWords.add("switch");
        keyWords.add("try");
        keyWords.add("void");

        String textFromFile = FileWorker.read(fileNamein);
    HashMap<String, Integer> keyWordsMap = KWcounter(textFromFile);
        for(
    Map.Entry pair:keyWordsMap.entrySet()) {
        fileWriter.write(String.valueOf(pair.getKey() + " = " +
                pair.getValue() + "\n"));
    }
}
        private static HashMap<String, Integer> KWcounter(String textFromFile){
            String[] str = textFromFile.split("\\W+");
            HashMap<String, Integer> keyWordsMap = new HashMap<>();
            int counter =0;
            for(int i=0; i<keyWords.size();i++) {
                String st = keyWords.get(i);
                for ( String word : str) {
                    if (word.contains(st)) {
                        if(keyWordsMap.containsKey(st)){
                            counter++;
                        }
                        else{
                            counter = 0;
                            counter++;
                        }
                        keyWordsMap.put(st, counter);
                    }
                }
            }
            return keyWordsMap;
        }
}