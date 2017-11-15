package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\norri\\IdeaProjects\\Mod6\\Ex1\\test.properties");
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            fis.close();

            Iterator iter = properties.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry entry =(Map.Entry)iter.next();
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (FileNotFoundException | NullPointerException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
