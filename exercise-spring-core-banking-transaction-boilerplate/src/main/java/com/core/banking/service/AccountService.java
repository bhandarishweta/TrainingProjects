package com.core.banking.service;

import com.core.banking.model.Account;

public class AccountService {

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public double checkAccountBalance() {
        return account.getBalance();
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    // Define a method to withdraw money from the account
    public void withdraw(double amount) {

        if(this.account.getBalance() > amount){
       this.account.setBalance(this.account.getBalance() - amount);
            // Decrease the balance of the account by the specified amount
            
        } else {
            System.out.println("Insufficient balance");
            // else print an error message if there is insufficient balance
           
        }
    }

}
