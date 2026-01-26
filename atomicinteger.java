import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    AtomicInteger balance = new AtomicInteger(0);

    void deposit(int amount) {
        balance.addAndGet(amount);
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

public class atomicinteger {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread t1 = new DepositTask(account, 1000);
        Thread t2 = new DepositTask(account, 1000);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final balance: " + account.balance.get());
    }
}
