package com.BankApp.Intro;

import java.util.ArrayList;

public class BankAccount {
	
	private String AccountNumber;
	private String HolderName;
	private double balance;
	ArrayList<Transaction>history=new ArrayList<>();
	
	//constructor
	public BankAccount(String AccountNumber,String HolderName,double balance)
	{
		this.AccountNumber=AccountNumber;
		this.HolderName=HolderName;
		this.balance=balance;
	}
	//deposite
	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance+=amount;
			history.add(new Transaction("Deposit",amount));
			System.out.println("Deposit: "+amount);
		}
		else
		{
			System.out.println("Deposit amount must be positive...");
		}
		
	}
	//withdraw money with custom Exception using if balance is insufficient 
	public void withdraw(double amount) throws InsufficientBalanceException
	{
		if(amount>balance)
		{
			throw new InsufficientBalanceException("Insufficient Balance!!!");
		}
		balance-=amount;
		history.add(new Transaction("Withdraw",amount));
		System.out.println("Withdraw: "+amount);
		
	}
	//get current balance
	public double getBalance()
	{
		return balance;
	}
	
	//print all transaction histories
	public void printTransactions()
	{
		if(history.isEmpty())
		{
			System.out.println("No transaction do yet...");
		}
		else
		{
			System.out.println("Transaction History ");
			for(Transaction t: history)
			{
				System.out.println(t);
			}
		}
	}
}
