package com.sachin;

/**
* @author sachin
* @date 15-Sep-2021
*/

public class FiveDollarDenomination implements DenominationChain {

	private DenominationChain chain;
	
	@Override
	public void setNextChain(DenominationChain next) {
		this.chain = next;
	}

	@Override
	public void withdrawDenomination(Currency cur) {
		if(cur.getAmount() >= 5){
			int num = cur.getAmount()/5;
			int remainder = cur.getAmount() % 5;
			System.out.println("Withdrwal of "+num+" items of 5$" );
			if(remainder !=0) this.chain.withdrawDenomination(new Currency(remainder));
		}else{
			this.chain.withdrawDenomination(cur);
		}
	}

}

