package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class ProductConfiguration {

 Scanner scanner = new Scanner(System.in);
	public static ArrayList<Services> createService() {
		// TODO Auto-generated method stub
		ArrayList<Services> serviceList = new ArrayList<Services>();
		serviceList.add(new Services("S01","CashDeposit",0.5));
		serviceList.add(new Services("S02","ATMWithdrawal",0.3));
		serviceList.add(new Services("S03","OnlineBanking",0.4));
		serviceList.add(new Services("S04","MobileBanking",0.6));
		serviceList.add(new Services("S05","ChequeDeposit",0.8));
		
		return serviceList;
	}

	public static Product createProduct(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		char addmoreservice;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Services> selectedServiceList = new ArrayList<Services>() ;
		System.out.println("Enter Product Code:");
		String productCode = scanner.next();
		System.out.println("Enter Product Name");
		String productName = scanner.next();
		do {
		System.out.println("Choose the Service you want to use");
		int index = 1;
        for(Services services : serviceList)
        {
        	System.out.println(index+"."+services.getServiceName());
        	index++;
        }
        int servicechoice = scanner.nextInt();
        selectedServiceList.add(serviceList.get(servicechoice-1));
        System.out.println("Do you want to add more service(y/n):");
        addmoreservice = scanner.next().charAt(0);
		}while(addmoreservice =='y');
		if(productName.equalsIgnoreCase("savingsmaxaccount"))
		{
		return new SavingsMaxAccount(productCode,productName,selectedServiceList);
		}
		else if(productName.equalsIgnoreCase("currentaccount"))
		{
		return new CurrentAccount(productCode,productName,selectedServiceList);
		}
		else if(productName.equalsIgnoreCase("loanaccount"))
		{
		return new LoanAccount(productCode,productName,selectedServiceList);
		}
		else {
		return null;
		}
		
	}
}
