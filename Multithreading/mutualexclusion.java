class BankAccount {
    private int balance = 1000;

    // synchronized method which enforces object lock
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);

            // simulating the delay
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+ " completed withdrawal. Balance = " + balance);
        } 
        else {
            System.out.println(Thread.currentThread().getName()+ " insufficient balance!");
        }
    }

    int getBalance() {
        return balance;
    }
}
public class mutualexclusion {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {account.withdraw(500);}, "Thread-1");
        Thread t2 = new Thread(() -> {account.withdraw(500);}, "Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Balance = " + account.getBalance());
    }
}
