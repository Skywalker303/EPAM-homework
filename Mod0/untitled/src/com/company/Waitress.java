package com.company;

import java.util.concurrent.Semaphore;

class Waitress extends Thread
{
    int col, dish;
    static Semaphore sem = new Semaphore(0);

    Waitress (int col, int dish)
    {
        this.col = col;
        this.dish = dish;
        new Thread(this,"Официантка").start();
    }

    public void run()
    {

        for (int i = 0; i < col; i++)
        {
            try
            { //разрешение на доступ к семафору
                Waitress.sem.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Блюдо " + Thread.currentThread().getName());
//освободим полученное ранее разрешение
            Customer.sem.release();
        }
    }
}
