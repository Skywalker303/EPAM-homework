package com.company;

import java.util.concurrent.Semaphore;

class Customer extends Thread
{
    int col, dish;
    static Semaphore sem = new Semaphore(0);

    Customer (int col, int dish)
    {
        this.col = col;
        this.dish = dish;
        new Thread(this,"Клиент").start();
    }

    public void run()
    {

        for (int i = 0; i < col; i++)
        {
            try
            { //разрешение на доступ к семафору
                Customer.sem.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Блюдо " + Thread.currentThread().getName());
            System.out.println();
//освободим полученное ранее разрешение
            Cook.sem.release();
        }
    }
}