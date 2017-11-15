

public class Main {

    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Welcome ");
        Caller ob2 = new Caller(target, "to");
        Caller ob3 = new Caller(target, "hell");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Stopped");
        }
    }

    static class Callme {
       synchronized void call(String msg) {
            System.out.print("[" + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Stopped");
            }
            System.out.println("]");
        }
    }

    static class Caller implements Runnable {
        String msg;
        Callme target;
        Thread t;

        public Caller(Callme targ, String s) {
            target = targ;
            msg = s;
            t = new Thread(this);
            t.start();
        }

        public void run() {
               synchronized (t){
                target.call(msg);
               }
        }
    }
    
}


