package com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)throws IOException {
        File file = new File("C:\\Users\\norri\\IdeaProjects\\Mod3\\Ex3\\src\\resources\\Java.SE.03.html");
        Pattern pattern = Pattern.compile("(Рис\\.\\s)[1-9]+");
        String line;
        StringBuilder text = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                (new FileInputStream(file), "CP1251"))){
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) {
                    System.out.printf("%s\n", line);
                    do text.append(matcher.group());
                    while (matcher.find());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            return;
        }

        String[] numArray = text.toString().split("\\D+");
        for (int i = 2;i < numArray.length;i++ ){
            if(Integer.parseInt(numArray[i-1]) > Integer.parseInt(numArray[i])) {
                System.out.print("  Not consistently!");
                break;
            }}
    }
}
