package com.company;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final String FILENAMEIN = "C:\\Users\\norri\\IdeaProjects\\Mod4\\Exc3\\words.txt";

    private static final String UNICODE_FILENAMEOUT = "C:\\Users\\norri\\IdeaProjects\\Mod4\\Exc3\\out.txt";

    public static void main(String[] args) {

        try {

            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(FILENAMEIN), "UTF8"))) {
                StringBuilder sb = new StringBuilder();

                String s;
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(UNICODE_FILENAMEOUT), "UTF16"))) {
                        bw.write(String.valueOf(sb));
                    }
                } catch(UnsupportedEncodingException | FileNotFoundException ex){
                    Logger.getLogger(Main.class.getName())
                            .log(Level.SEVERE, null, ex);
                } catch(IOException ex){
                    Logger.getLogger(Main.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
