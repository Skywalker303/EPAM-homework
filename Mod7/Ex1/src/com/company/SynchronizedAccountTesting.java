package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedAccountTesting implements Runnable {
    private Account acct = new Account();

    private static String fileNamein = "C:\\Users\\norri\\IdeaProjects\\Mod7\\operations.txt";

    public static void main(String[] args) {

        Map<List<String>, List<Integer>> hm = new ConcurrentHashMap<>();
        String l = null;
        Integer i = null;
        try {
            String textFromFile = FileWorker.read(fileNamein);
            String[] str = textFromFile.split(" ");
            List<Integer> ali = null;
            List<String> als = null;
            System.out.println("синхронизация с помощью java.util.concurrent");
            for (String s : str) {

                if (s.length() > 3) {
                    l = s;
                } else {
                    i = Integer.parseInt(s);
                }
                als = new ArrayList<>();
                ali = new ArrayList<>();

                als.add(l);
                ali.add(i);
                hm.put(als, ali);

                System.out.println(hm);

            }
            System.out.println(" ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SynchronizedAccountTesting r = new SynchronizedAccountTesting();
        Thread one = new Thread(r);
        Thread two = new Thread(r);
        one.setName("account1");
        two.setName("account2");
        System.out.println("синхронизация с помощью ключевого слова synchronized");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            makeDeposit(5);
            if (acct.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amt) {
        if (acct.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            acct.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + acct.getBalance());
        }
    }

    private synchronized void makeDeposit(int amt) {

        System.out.println(Thread.currentThread().getName() + " is going to deposit");
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
        }
        acct.deposit(amt);
        System.out.println(Thread.currentThread().getName() + " completes the deposit");
    }
}