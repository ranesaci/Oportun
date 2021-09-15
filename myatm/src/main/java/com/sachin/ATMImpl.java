package com.sachin;

import java.util.HashMap;
import java.util.Map;

/**
* @author sachin
* @date 15-Sep-2021
*/

public class ATMImpl implements ATM {
	private static Map<Integer, Integer> customerIdBalanceMap = new HashMap<>();
	private enum ActionType { DEPOSIT, WITHDRAW}
	
	static {
		customerIdBalanceMap.put(12345, 100);
		customerIdBalanceMap.put(12346, 100);
		customerIdBalanceMap.put(12347, 100);
	}

	@Override
	public void deposit(int amount, int customerId) {
		if (validate(amount, customerId, null)) {
			int balance = customerIdBalanceMap.get(customerId);
			int newBalance = balance + amount;
			customerIdBalanceMap.put(customerId, newBalance);
			System.out.println("Deposited:"+ amount + " and total balance:" + newBalance);
		}
		
	}

	@Override
	public void withdraw(int amount, int customerId) {
		
		if (validate(amount, customerId, ActionType.WITHDRAW))
		{
			Currency currency = new Currency(amount);
			DenominationChainConfig.getDollarDenominationChain().withdrawDenomination(currency);
			int balance = customerIdBalanceMap.get(customerId);
			int newBalance = balance - currency.getAmount();
			//update balance
			customerIdBalanceMap.put(customerId, newBalance);
			System.out.println("Withdrawn:"+ amount + " and total balance:" + newBalance);
		}
	}
	
	public boolean validate(int amount, int customerId, ActionType actionType) {
		if (amount < 0) {
			System.out.println("negative amount is not allowed");
			return false;
		}
		if (amount % 5 != 0) {
			System.out.println("Amount should be in multiple of 20s or 10s or 5s or 1s.");
			return false;
		}
		
		if (!customerIdBalanceMap.containsKey(customerId)) {
			System.out.println("Invalid customer!");
			return false;
		}
		
		if (ActionType.WITHDRAW == actionType && amount > customerIdBalanceMap.get(customerId)) {
			System.out.println("Insufficient Funds");
			return false;
		}
		
		return true;
	}
	
	public int getBalance(int customerId) {
		return customerIdBalanceMap.get(customerId);
	}

}


