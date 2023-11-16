package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	double minimumBalance = 1000;
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> serviceList,
			double minimumBalance) {
		super(productCode, productName, serviceList);
		this.minimumBalance = minimumBalance;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}
	

}
