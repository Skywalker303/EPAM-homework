package com.company;

import java.io.*;
import java.util.List;

public class FileWorker {
    public FileWorker() throws FileNotFoundException {}

    public static void write(String fileName, List<String> words) throws IOException {
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file);

            fw.write(String.valueOf(words));

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            fw.close();
        }
    }

    public static String read(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        String line;
        exists(fileName);
        File file = new File(fileName);
        try {
            br = new BufferedReader(new FileReader(file));
            try {
                while ((line =br.readLine())!=null) {
                    sb.append(line);
                }
            } finally {
                br.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
}
