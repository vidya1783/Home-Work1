package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber); }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance); }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = this.getBalance() - amountToWithdraw;
        if (amountToWithdraw > this.getBalance()) {
            return this.getBalance();
        } else if (newBalance < 150) {
            return super.withdraw(amountToWithdraw + 2);
        } else {
            return super.withdraw(amountToWithdraw);
        }
    }}



