package com.company;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.util.Enumeration;
        import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\norri\\IdeaProjects\\Mod5\\Ex2\\test.properties");
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            fis.close();

            Enumeration eks = properties.keys();
            while (eks.hasMoreElements()) {
                String key = (String) eks.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + ": " + value);
            }

        } catch (FileNotFoundException | NullPointerException e){
            System.out.println("There isn't any key in properties file or file doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
