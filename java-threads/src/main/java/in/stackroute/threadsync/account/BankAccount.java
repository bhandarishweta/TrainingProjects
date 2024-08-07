package in.stackroute.threadsync.account;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient " +
                    "balance");
        }
    }
}
