package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main
{
    public static void main(String [] args)
    {
        HashMap<String, String> filmmap = new HashMap<String, String>();
        //Adding elements to HashMap
        filmmap.put("Andrei Mironov", "The Diamond arm");
        filmmap.put("Andrei Mironov", "The tvelve chairs");
        filmmap.put("Jim Carrey", "The Mask");
        filmmap.put("Jim Carrey", "Bruce Almighty");
        filmmap.put("Antonio Banderas", "Desperado");
        try
        {
            FileOutputStream fos =
                    new FileOutputStream("C:\\Users\\norri\\IdeaProjects\\Mod4\\Exc4\\filmslib.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(filmmap);
            oos.close();
            fos.close();
            System.out.printf("Serialized HashMap data is saved in filmslib.ser");
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        try
        {
            FileInputStream fis = new FileInputStream("filmslib.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            filmmap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("\n");
        System.out.println("Deserialized HashMap..");
        Set set = filmmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Object s = entry.getKey();
            Object st = entry.getValue();
            System.out.printf("%s is an actor of a film which is called: %s;\n",s,st);
        }
    }
}
