package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MTproperties {

    static String line;

    public static void main(String[] args) {
        File file = new File("C:\\Users\\norri\\IdeaProjects\\Mod7\\Ex2\\test.properties");
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                    while ((line = reader.readLine()) != null) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        service.shutdown();
    }
}
