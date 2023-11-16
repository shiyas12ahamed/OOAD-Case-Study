package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class AccountConfiguration {
	public static Customer createCustomer(Customer customer,ArrayList<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		char choiceMoreAccount;
		ArrayList<Account> accountList = new ArrayList<Account>();
		System.out.println("****Products Available***********");
		String customerCode = "";
		String customerName = "";
		int index=1;
		for(Product product:productList)
		{
			System.out.println(index+"."+product.getProductName());
			index++;
		}
		do {
		System.out.println("Enter your Choice:");
		int productChoice = scanner.nextInt();
		Product selectedProduct = productList.get(productChoice - 1);
		System.out.println("Enter Account Number:");
		String accountNo = scanner.next();
		System.out.println("Enter Account Balance:");
		double accountBalance = scanner.nextDouble();
		Account account = new Account(accountNo,accountBalance,selectedProduct);
		
		accountList.add(account);
		if(customer == null)
		{
			System.out.println("Enter Customer Code:");
			customerCode = scanner.next();
			System.out.println("Enter Customer Name:");
			customerName = scanner.next();
			customer = new Customer(customerCode,customerName,accountList);
		}
		System.out.println(selectedProduct.getProductName() + " created for " + customer.getCustomerName() +
                " with the following Services:");
        for (Services service : selectedProduct.getServiceList()) {
           System.out.println(service.getServiceName());
        }
		System.out.println("Account is active!!!!!");
		System.out.println("Do you want to add more account(y/n)");
		choiceMoreAccount = scanner.next().charAt(0);
		}while(choiceMoreAccount=='y');
		return customer;
		
	}
	public static void displayAccount(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("*************************Customer-Account Details****************");
    System.out.println("CustomerId\tCustomerName\t\tAccountType\t\tBalance");
	    System.out.println("***************************************************************");

	        for (Account account : customer.getAccountList()) {
	            System.out.println(customer.getCustomerCode() + "\t\t" + customer.getCustomerName() +
	                    "\t\t" + account.getProduct().getProductName() + "\t\t" + account.getAccountBalance());
	        }
	 

	        for(Account account : customer.getAccountList()) {
				System.out.println("Services for "+customer.getCustomerName());
				ArrayList<Services> selectedServiceList = account.getProduct().getServiceList();
				for(Services service : selectedServiceList) {
					System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
				}
			}
	}
	   

   
	public static void createTransactionBill(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer Code:");
		String customerCode = scanner.nextLine();
		if(customerCode.equals(customer.getCustomerCode()))
				{
		System.out.println(customer.getCustomerName()+ " has the following accounts:");
		for(Account account : customer.getAccountList()) {
			System.out.println((customer.getAccountList().indexOf(account) +1)+"." +account.getProduct().getProductName());
			System.out.println("Enter your choice:");
			int accountChoice = scanner.nextInt();
			System.out.println("Choose the Service you want to use :");
			Account selectedAccount = customer.getAccountList().get(accountChoice-1);
			ArrayList<Services> selectedServiceList = selectedAccount.getProduct().getServiceList();
			for(Services service : selectedServiceList) {
				System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
			}
			System.out.println("Enter your choice:");
			int selectedService = scanner.nextInt();
			System.out.print("Enter the number of transaction:");
			int numberoftransactions = scanner.nextInt();
			System.out.println("Total transaction bill="+(selectedServiceList.get(selectedService-1).getServicePrice())*numberoftransactions);
		
	}
				}
		else {
			System.out.println("Customer does not exist");
		}
	}
	public static void manageAccounts(Customer customer, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer Code:");
		String customerCode = scanner.nextLine();
		if(customerCode.equals(customer.getCustomerCode()))
				{
			System.out.println("Welcome "+customer.getCustomerName());
			System.out.println("Select account you want to manage");
			int index = 1 ;
			for(Account account : customer.getAccountList()) {
				System.out.println(index+"."+account.getProduct().getProductCode()+"-"+account.getProduct().getProductName());
				index++;
			}
			int accountChoice = scanner.nextInt();
			Account selectedAccount = customer.getAccountList().get(accountChoice-1);
			ArrayList<Services> selectedServiceList = selectedAccount.getProduct().getServiceList();
			for(Services service : selectedServiceList) {
				System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
			}
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			String choiceString = selectedServiceList.get(choice-1).getServiceCode();
			if(choiceString.equals("S01"))
			{
				System.out.println("Selected:Cash Deposit");
				System.out.println("Enter the amount to deposit:");
				double deposit = scanner.nextDouble();
				selectedAccount.setAccountBalance((selectedAccount.getAccountBalance())+(deposit));
				System.out.println("Deposit successfull. New Account Balance:"+selectedAccount.getAccountBalance());
				
			}
			else if(choiceString.equals("S02"))
			{
				System.out.println("Selected:ATM Withdrawal");
				System.out.println("Enter the amount to withdraw:");
				double withdraw = scanner.nextDouble();
				double balance = selectedAccount.getAccountBalance() - withdraw ;
				if (selectedAccount.getProduct() instanceof SavingsMaxAccount) {
				    SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) selectedAccount.getProduct();

				    // Accessing minimumBalance using the getter method
				    double minimumBalance = savingsMaxAccount.getMinimumBalance();

				if(balance<minimumBalance)
					{
					System.out.println("Since you have SavingsMax Account balance should not stay above 1000");
					System.out.println("Withdraw Failed");
					}
					else {
					selectedAccount.setAccountBalance(balance);
					System.out.println("Withdraw successfull. New Account Balance:"+selectedAccount.getAccountBalance());
					}
				}
				else if(balance<0)
				{
					System.out.println("Withdraw Failed - Insufficient Balance");
				}
				else {
					selectedAccount.setAccountBalance(balance);
					System.out.println("Withdraw successfull. New Account Balance:"+selectedAccount.getAccountBalance());
				}
				}
				
				
				
			else if(choiceString.equals("S03"))
			{
				System.out.println("Selected:Online Banking");
			}
			else if(choiceString.equals("S04"))
			{
				System.out.println("Selected:Mobile Banking");
			}
			else if(choiceString.equals("S05"))
			{
				System.out.println("Selected:Cheque Deposit");
				System.out.println("Selected:Cash Deposit");
				System.out.println("Enter the amount to deposit:");
				double deposit = scanner.nextDouble();
				if (selectedAccount.getProduct() instanceof LoanAccount) {
				    LoanAccount loanAccount = (LoanAccount) selectedAccount.getProduct();

				    // Accessing minimumBalance using the getter method
				    double depositCharge = loanAccount.getDepositcharge();
					System.out.println("Since you have Loan Account"+depositCharge+"% will be charged.");
					selectedAccount.setAccountBalance((selectedAccount.getAccountBalance())+(deposit - (depositCharge/100)*deposit));
				}
				else {
					selectedAccount.setAccountBalance((selectedAccount.getAccountBalance())+(deposit));
				}
				System.out.println("Deposit successfull. New Account Balance:"+selectedAccount.getAccountBalance());
				
			}
			}
		else {	
				
					System.out.println("Customer does not exist");
				}
	}
}
				
		
		
