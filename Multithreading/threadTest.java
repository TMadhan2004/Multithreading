class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 1_000_000; i++); 
        System.out.println(Thread.currentThread().getName());
    }
}

public class threadTest {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
