package in.stackroute.threadsync.account;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTransaction {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount(1000);

        Runnable deposit = () -> {
            for(int i = 0; i < 10000; i++) {
                account.deposit(100);
            }
        };
        Runnable withdraw = () -> {
            for(int i = 0; i < 10000; i++) {
                account.withdraw(100);
            }
        };

        List<Runnable> tasks = List.of(deposit, withdraw, deposit, withdraw, deposit, withdraw, deposit, withdraw,
                deposit, withdraw);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        tasks.forEach(executor::submit);
        executor.shutdown();
        executor.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);

        System.out.println("Final balance: " + account.getBalance());
    }
}
