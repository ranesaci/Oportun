package com.sachin;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
* @author sachin
* @date 15-Sep-2021
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestATM {
	
	@Test
	public void test1Deposit() {
		ATM atm = new ATMImpl();
		int cusomerId = 12345;
		atm.deposit(10, cusomerId);
		assertEquals(110, atm.getBalance(cusomerId));
	}

	@Test
	public void test2Withdraw() {
		ATM atm = new ATMImpl();
		int cusomerId = 12345;
		atm.withdraw(55, cusomerId);
		assertEquals(55, atm.getBalance(cusomerId));
	}
	
	@Test
	public void test3InsufficientFund() {
		ATM atm = new ATMImpl();
		int cusomerId = 12345;
		atm.withdraw(100, cusomerId);
		//balace will be same
		assertEquals(55, atm.getBalance(cusomerId));
	}

}


