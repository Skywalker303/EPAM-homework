package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", res);
        List<IntegerSetterGetter> threadsList = Arrays.asList(t1, t2, t3, t4, t5);
        res.setThreadCount(threadsList.size());
        for(Thread t:threadsList){
            t.start();
        }
        Thread.sleep(100);
        for(IntegerSetterGetter isg:threadsList){
            isg.stopThread();
        }
        for(Thread t:threadsList){
            t.join();
        }
        System.out.println("main");
    }
    static class IntegerSetterGetter extends Thread {
        private SharedResource resource;
        private boolean run;
        private Random rand = new Random();

        public IntegerSetterGetter(String name, SharedResource resource) {
            super(name);
            this.resource = resource;
            run = true;
        }

        public void stopThread() {
            run = false;
        }

        public void run() {
            int action;
            try {
                while (run) {
                    action = rand.nextInt(1000);
                    if (action % 2 == 0) {
                        resource.setGetterCount(resource.getGetterCount() + 1);
                        if (resource.getGetterCount() > resource.getThreadCount() / 2)
                            setIntegersIntoResource();
                        else getIntegersFromResource();
                    } else {
                        setIntegersIntoResource();
                    }
                }
                System.out.println("Поток " + getName() + " завершил работу.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private synchronized void getIntegersFromResource() throws InterruptedException {
            Integer number;

            System.out.println("Поток " + getName() + " хочет извлечь число.");
            synchronized (resource) {
                while (resource.getList().isEmpty()) {
                    System.out.println(" Поток " + getName() + " ждет пока очередь заполнится.");
                    resource.wait();
                }
                System.out.println("Поток " + getName() + " возобновил работу. ");
                number = resource.getElement();
                System.out.println(" Поток " + getName() + " извлек число " + number);
                resource.notifyAll();
            }
        }

        private synchronized void setIntegersIntoResource() throws InterruptedException {
            Integer number = rand.nextInt(500);
            synchronized (resource) {
                resource.setElement(number);
                System.out.println("Поток " + getName() + " записал число " + number);
                resource.notifyAll();
            }
        }
    }
}
