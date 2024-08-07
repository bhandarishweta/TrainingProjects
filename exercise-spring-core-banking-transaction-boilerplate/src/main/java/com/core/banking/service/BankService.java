package com.core.banking.service;

import com.core.banking.model.Account;

public class BankService {

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

   //Method to check the account balance
public double checkAccountBalance() {
    // Check if the account is initialized (not null)
    if (this.account != null) {
        return this.account.getBalance();
        // Return the balance of the account
    } else {
        // Print an error message if the account is not initialized
       System.out.println("The account is not initialized.");
       return 0.0;
        // Return 0.0 as a default balance
    }
}

    public void deposit(double amount) {
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
        } else {
            System.out.println("Account not initialized");
        }
    }


    public boolean withdraw(double amount) {
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds or account not initialized
        }
    }
}
