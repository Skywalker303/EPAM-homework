package com.company;

import java.util.concurrent.Semaphore;

class Cook implements Runnable
{
    int col;
    int dish;
    static Semaphore sem = new Semaphore(1);

    Cook(int col, int dish)
    {
        this.col = col;
        this.dish = dish;
        new Thread(this,"Повар").start();
    }

    public void run()
    {
        for (int i = 0; i < col; i++)
        {
            try
            { //разрешение на доступ к семафору
                Cook.sem.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Блюдо " + Thread.currentThread().getName());
//освободим полученное ранее разрешение
            Waitress.sem.release();
        }
    }
}