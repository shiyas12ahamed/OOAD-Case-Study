package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Customer customer = null;
			ArrayList<Services> serviceList = new ArrayList<Services>();
			ArrayList<Product> productList = new ArrayList<Product>();
			System.out.println("******Welcome To Bank************");
			char goToMainMenu;
			serviceList.addAll(ProductConfiguration.createService());
			do{
			System.out.println("1.Create Product\n2.Create Customer\n3.Manage Accounts\n4.Display Customer\n5.Transaction Bill");
			System.out.print("Enter your choice: ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					productList.add(ProductConfiguration.createProduct(serviceList));
					break;
				case 2:
					customer = AccountConfiguration.createCustomer(customer,productList);
					break;
				case 3:
					AccountConfiguration.manageAccounts(customer,productList);
					break;
				case 4:
					AccountConfiguration.displayAccount(customer);
					break;
				case 5:
					AccountConfiguration.createTransactionBill(customer);
					break;
				}
		System.out.println("Go back to main menu (y/n)");
		goToMainMenu=scanner.next().charAt(0);
		}while(goToMainMenu=='y');
	}

}
