import java.util.concurrent.atomic.AtomicReference;

class BankAccount {
    private final int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    BankAccount deposit(int amount) {
        return new BankAccount(this.balance + amount);
    }

    int getBalance() {
        return balance;
    }
}

public class immutability {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<BankAccount> account = new AtomicReference<>(new BankAccount(0));
        Thread t1 = new Thread(() -> {account.set(account.get().deposit(1000));});
        Thread t2 = new Thread(() -> {account.set(account.get().deposit(1000));});
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Balance: " + account.get().getBalance());
    }
}
