package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
    double depositcharge = 0.3;
	public LoanAccount(String productCode, String productName, ArrayList<Services> serviceList, double depositcharge) {
		super(productCode, productName, serviceList);
		this.depositcharge = depositcharge;
	}
	public double getDepositcharge() {
		return depositcharge;
	}
	public void setDepositcharge(double depositcharge) {
		this.depositcharge = depositcharge;
	}
	public LoanAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}

}
