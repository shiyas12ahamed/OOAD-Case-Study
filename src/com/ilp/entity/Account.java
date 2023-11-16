package com.ilp.entity;

public class Account {
private String accountNumber;
private double accountBalance;
private Product product;
public String getAccountNumber() {
	return accountNumber;
}
public Account(String accountNumber, double accountBalance, Product product) {
	this.accountNumber = accountNumber;
	this.accountBalance = accountBalance;
	this.product = product;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public double getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
}
