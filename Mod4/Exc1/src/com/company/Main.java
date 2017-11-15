package com.company;

import java.io.*;
import java.util.*;


public class Main {
    private static String fileNamein = "C:\\Users\\norri\\IdeaProjects\\Mod3\\Ex1\\src\\com\\company\\Main.java";
    private static String fileNameout = "C:\\Users\\norri\\IdeaProjects\\Mod4\\Exc1\\KWords.txt";

    static List<String> keyWords = new ArrayList<>();
    public static void main(String[] args)throws FileNotFoundException {
        try(FileInputStream fis = new FileInputStream(new File(fileNamein));
        FileOutputStream fos = new FileOutputStream(new File(fileNameout));)
         {
                Counter(fis,fos);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void Counter(InputStream inputStream, OutputStream outputStream)
            throws IOException{
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

       byte [] bArray = FileWorker.read(inputStream);
        String textFromFile = new String(bArray);
        HashMap<String, Integer> keyWordsMap = KWcounter(textFromFile);
        for (Map.Entry pair : keyWordsMap.entrySet()) {
            outputStream.write(String.valueOf(pair.getKey() + " = " +
                    pair.getValue() + "\n").getBytes());
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
