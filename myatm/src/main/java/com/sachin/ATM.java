package com.sachin;

/**
* @author sachin
* @date 15-Sep-2021
*/

public interface ATM {
	public void deposit(int amount, int customerId);

	public void withdraw(int amount, int customerId);
	
	public int getBalance(int customerId);
}

