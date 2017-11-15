package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeReader {

    private static final String INPUT_FILE_PATH = "C:\\Users\\norri\\IdeaProjects\\Mod3\\Ex2\\src\\com\\company\\Main.java";
    private static final String BYTE_OUTPUT_FILE_PATH = "C:\\Users\\norri\\IdeaProjects\\Mod0\\Ex4.1\\src\\com\\company\\resources\\ByteOutput.txt";
    private static final String CHAR_OUTPUT_FILE_PATH = "C:\\Users\\norri\\IdeaProjects\\Mod0\\Ex4.1\\src\\com\\company\\resources\\CharOutput.txt";
    private static final String[] KEYWORDS = {"abstract", "assert", "boolean", "break", "byte", "case",
            "catch", "char", "class", "const", "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient",
            "try", "void", "volatile", "while",};//Sorted array of java keyWords

    private static void byteKeyWordsCounter(InputStream inputStream, OutputStream outputStream)
            throws IOException{

        byte[] byteArray = new byte[inputStream.available()];
        if (inputStream.read(byteArray) < byteArray.length)
            throw new IOException("Can't read all file");
        String code = new String(byteArray);
        HashMap<String, Integer> keyWordsMap = countKeyWords(code);

        for (Map.Entry pair : keyWordsMap.entrySet()) {
            outputStream.write(String.valueOf(pair.getKey() + " = " +
                    pair.getValue() + "\n").getBytes());
        }
    }

    private static void charKeyWordsCounter(BufferedReader bufferedReader, Writer writer) throws IOException{
        StringBuilder code = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null)
            code.append(line);
        HashMap<String, Integer> keyWordsMap = countKeyWords(code.toString());

        for (Map.Entry pair : keyWordsMap.entrySet()) {
            writer.write(String.valueOf(pair.getKey() + " = " +
                    pair.getValue() + "\n"));
        }
    }

    private static HashMap<String, Integer> countKeyWords(String code){
        String[] codeArray = code.split("\\W+");
        HashMap<String, Integer> keyWordsMap = new HashMap<>();
        for(String codeWord : codeArray) {
            if (Arrays.binarySearch(KEYWORDS, codeWord) > -1) {
                // If there isn't this code word put this word and set value as 1. Else increase the value by 1.
                keyWordsMap.put(codeWord, keyWordsMap.getOrDefault(codeWord, 0) + 1);
            }
        }
        return keyWordsMap;
    }

    public static void main(String[] args) {

        try(FileInputStream iS = new FileInputStream(new File(INPUT_FILE_PATH));
            FileOutputStream oS = new FileOutputStream(new File(BYTE_OUTPUT_FILE_PATH));
            BufferedReader bR = new BufferedReader(new FileReader(new File(INPUT_FILE_PATH)));
            FileWriter fW = new FileWriter(new File(CHAR_OUTPUT_FILE_PATH))) {

            byteKeyWordsCounter(iS,oS);
            charKeyWordsCounter(bR,fW);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}