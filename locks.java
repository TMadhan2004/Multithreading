import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 0;
    private Lock lock = new ReentrantLock();

    void deposit(int amount) {
        lock.lock(); // acquire lock
        try {
            balance += amount;  // critical section
        } finally {
            lock.unlock();  // release lock (always)
        }
    }

    int getBalance() {
        return balance;
    }
}

class DepositTask extends Thread {
    BankAccount account;
    int amount;

    DepositTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount);
    }
}

public class locks {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread t1 = new DepositTask(account, 1000);
        Thread t2 = new DepositTask(account, 1000);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Balance: " + account.getBalance());
    }
}
