class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            //This is a demanding loop
        }

        System.out.println(Thread.currentThread().getName());
    }
}

public class priority {

    public static void main(String[] args) {

        Thread t1 = new MyThread("High priority thread");
        Thread t2 = new MyThread("Low priority thread");
        Thread t3 = new MyThread("Medium priority thread");

        t1.setPriority(Thread.MAX_PRIORITY);   
        t2.setPriority(Thread.MIN_PRIORITY);   
        t3.setPriority(Thread.NORM_PRIORITY);  

        t1.start();
        t2.start();
        t3.start();
    }
}
