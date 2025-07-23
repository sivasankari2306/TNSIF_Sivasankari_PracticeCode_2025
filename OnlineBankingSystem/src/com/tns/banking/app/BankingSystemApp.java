package com.tns.banking.app;

import com.tns.banking.entities.Account;
import com.tns.banking.entities.Beneficiary;
import com.tns.banking.entities.Customer;
import com.tns.banking.entities.Transaction;
import com.tns.banking.services.BankingService;
import com.tns.banking.services.BankingServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BankingSystemApp {
	
	  private static BankingService bankingService = new BankingServiceImpl();
	    private static Scanner scanner = new Scanner(System.in);
	    private static int customerIdCounter = 1;
	    private static int accountIdCounter = 101;
	    private static int transactionIdCounter = 1;
	    private static int beneficiaryIdCounter = 1001;

	    public static void main(String[] args) {
	        int choice;
	        do {
	            displayMenu();
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    addCustomer();
	                    break;
	                case 2:
	                    addAccount();
	                    break;
	                case 3:
	                    addBeneficiary();
	                    break;
	                case 4:
	                    addTransaction();
	                    break;
	                case 5:
	                    findCustomerById();
	                    break;
	                case 6:
	                    listAccountsOfSpecificCustomer();
	                    break;
	                case 7:
	                    listTransactionsOfSpecificAccount();
	                    break;
	                case 8:
	                    listBeneficiariesOfSpecificCustomer();
	                    break;
	                case 9:
	                    System.out.println("Thank you!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	            System.out.println("\n-------------------------------------\n");
	        } while (choice != 9);

	        scanner.close();
	    }

	    private static void displayMenu() {
	        System.out.println("Banking System");
	        System.out.println("1. Add Customers");
	        System.out.println("2. Add Accounts");
	        System.out.println("3. Add Beneficiary");
	        System.out.println("4. Add Transaction");
	        System.out.println("5. Find Customer by Id");
	        System.out.println("6. List all Accounts of specific Customer");
	        System.out.println("7. List all transactions of specific Account");
	        System.out.println("8. List all beneficiaries of specific customer");
	        System.out.println("9. Exit");
	    }

	    private static void addCustomer() {
	        System.out.println("Enter Customer Details");
	        System.out.print("Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Address: ");
	        String address = scanner.nextLine();
	        System.out.print("Contact No.: ");
	        String contact = scanner.nextLine();

	        Customer customer = new Customer(customerIdCounter++, name, address, contact);
	        bankingService.addCustomer(customer);
	    }

	    private static void addAccount() {
	        System.out.println("Enter Account Details");
	        System.out.print("Customer Id: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        // Check if customer exists
	        if (bankingService.findCustomerById(customerId) == null) {
	            System.out.println("Customer with ID " + customerId + " not found. Please add the customer first.");
	            return;
	        }

	        System.out.print("Account Type (Saving/Current): ");
	        String type = scanner.nextLine();
	        System.out.print("Balance: ");
	        double balance = scanner.nextDouble();
	        scanner.nextLine(); // Consume newline

	        Account account = new Account(accountIdCounter++, customerId, type, balance);
	        bankingService.addAccount(account);
	    }

	    private static void addBeneficiary() {
	        System.out.println("Enter Beneficiary Details");
	        System.out.print("Customer Id: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        // Check if customer exists
	        if (bankingService.findCustomerById(customerId) == null) {
	            System.out.println("Customer with ID " + customerId + " not found. Please add the customer first.");
	            return;
	        }

	        System.out.print("Beneficiary Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Beneficiary Account No.: ");
	        String accountNumber = scanner.nextLine();
	        System.out.print("Beneficiary Bank details: ");
	        String bankDetails = scanner.nextLine();

	        Beneficiary beneficiary = new Beneficiary(beneficiaryIdCounter++, customerId, name, accountNumber, bankDetails);
	        bankingService.addBeneficiary(beneficiary);
	    }

	    private static void addTransaction() {
	        System.out.println("Enter Transaction Details");
	        System.out.print("Account Id: ");
	        int accountId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        // Check if account exists
	        if (bankingService.findAccountById(accountId) == null) {
	            System.out.println("Account with ID " + accountId + " not found. Please add the account first.");
	            return;
	        }

	        System.out.print("Type (Deposit/Withdrawal): ");
	        String type = scanner.nextLine();
	        System.out.print("Amount: ");
	        double amount = scanner.nextDouble();
	        scanner.nextLine(); // Consume newline

	        Transaction transaction = new Transaction(transactionIdCounter++, accountId, type, amount);
	        bankingService.addTransaction(transaction);
	    }

	    private static void findCustomerById() {
	        System.out.print("Enter Customer ID to find: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        Customer customer = bankingService.findCustomerById(customerId);
	        if (customer != null) {
	            System.out.println("Customer: " + customer.getName());
	            System.out.println(customer);
	        } else {
	            System.out.println("Customer with ID " + customerId + " not found.");
	        }
	    }

	    private static void listAccountsOfSpecificCustomer() {
	        System.out.print("Enter Customer ID: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        List<Account> accounts = bankingService.getAccountsByCustomerId(customerId);
	        if (accounts.isEmpty()) {
	            System.out.println("No accounts found for Customer ID: " + customerId);
	        } else {
	            System.out.println("Accounts for Customer ID :" + customerId);
	            for (Account account : accounts) {
	                System.out.println(account);
	            }
	        }
	    }

	    private static void listTransactionsOfSpecificAccount() {
	        System.out.print("Enter Account Id: ");
	        int accountId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        List<Transaction> transactions = bankingService.getTransactionsByAccountId(accountId);
	        if (transactions.isEmpty()) {
	            System.out.println("No transactions found for Account ID: " + accountId);
	        } else {
	            System.out.println("Transactions for Account ID :" + accountId);
	            for (Transaction transaction : transactions) {
	                System.out.println(transaction);
	            }
	        }
	    }

	    private static void listBeneficiariesOfSpecificCustomer() {
	        System.out.print("Enter Customer Id: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        List<Beneficiary> beneficiaries = bankingService.getBeneficiariesByCustomerId(customerId);
	        if (beneficiaries.isEmpty()) {
	            System.out.println("No beneficiaries found for Customer ID: " + customerId);
	        } else {
	            System.out.println("Beneficiaries for Customer ID :" + customerId);
	            for (Beneficiary beneficiary : beneficiaries) {
	                System.out.println(beneficiary);
	            }
	        }
	    }

}
