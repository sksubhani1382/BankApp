package com.BankApp.Intro;

import java.util.Scanner;

public class BankAppMain
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the AccountNumber: ");
		String accNum=sc.nextLine();
		System.out.println("Enter the holder name: ");
		String holder=sc.nextLine();
		System.out.println("Enter the Initial balance: ");
		double initBalance=sc.nextDouble();
		
		BankAccount account=new BankAccount(accNum,holder,initBalance);
		
		while(true)
		{
			System.out.println("// Bank Menu \\");
			System.out.println("1. Deposit");
			System.out.println("2. WithDraw");
			System.out.println("3. Show Balance");
			System.out.println("4. Show Transactions");
			System.out.println("5. Exit");
			System.out.println("Choose an Option");
			
			int choice=sc.nextInt();
			
			try 
			{
				switch(choice)
				{
				case 1:
					System.out.println("Enter amount to deposit: ");
					double dep=sc.nextDouble();
					account.deposit(dep);
					break;
					
				case 2:
					System.out.println("Enter to amount WithDraw: ");
					double wid=sc.nextDouble();
					account.withdraw(wid);
					break;
				case 3:
					System.out.println("Current Balance: "+account.getBalance());
					break;
				case 4:
					System.out.println("Print Transaction: ");
					account.printTransactions();
					break;
				case 5:
					System.out.println("Exit process successfully!!!");
					sc.close();
					System.exit(0);
				default:
					System.out.println("Invalid choice PLease try again!!!");
					
				}
				
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println("Error: "+e.getMessage());
			}
		}
		
	}

}
