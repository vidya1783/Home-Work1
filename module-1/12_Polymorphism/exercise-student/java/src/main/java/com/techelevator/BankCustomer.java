package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable>accounts=new ArrayList<>();

    public String getName(){
           return name;
      }
      public String getAddress(){
        return address;
      }
      public String getPhoneNumber(){
        return phoneNumber;
      }
    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    @Override
    public int getBalance() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount){
        //Adds newAccount to the customer's list of accounts.
        accounts.add(newAccount);
    }

        public boolean isVip(){
            int balance = 0;
            for(Accountable total : accounts){
                balance += total.getBalance();
            }
            if(balance >= 25000){
                return true;
            }
            return false;
}}
