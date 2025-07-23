package com.tns.banking.entities;

public class Account {
	
	 private int accountID;
	    private int customerID;
	    private String type; // Saving/Current
	    private double balance;

	    public Account(int accountID, int customerID, String type, double balance) {
	        this.accountID = accountID;
	        this.customerID = customerID;
	        this.type = type;
	        this.balance = balance;
	    }

	    // Getters and Setters
	    public int getAccountID() {
	        return accountID;
	    }

	    public void setAccountID(int accountID) {
	        this.accountID = accountID;
	    }

	    public int getCustomerID() {
	        return customerID;
	    }

	    public void setCustomerID(int customerID) {
	        this.customerID = customerID;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            this.balance += amount;
	            System.out.println("Deposit successful. New balance: " + this.balance);
	        } else {
	            System.out.println("Deposit amount must be positive.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && this.balance >= amount) {
	            this.balance -= amount;
	            System.out.println("Withdrawal successful. New balance: " + this.balance);
	        } else if (amount <= 0) {
	            System.out.println("Withdrawal amount must be positive.");
	        } else {
	            System.out.println("Insufficient balance.");
	        }
	    }

	    @Override
	    public String toString() {
	        return "Account ID: " + accountID + ", Customer ID: " + customerID + ", Type: " + type + ", Balance: " + balance;
	    }

}
