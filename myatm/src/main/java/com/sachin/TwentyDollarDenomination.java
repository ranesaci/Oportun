package com.sachin;

/**
* @author sachin
* @date 15-Sep-2021
*/

public class TwentyDollarDenomination implements DenominationChain {

	private DenominationChain chain;
	
	@Override
	public void setNextChain(DenominationChain next) {
		this.chain = next;
	}

	@Override
	public void withdrawDenomination(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Withdrwal of "+num+" items of 20$" );
			if(remainder !=0) this.chain.withdrawDenomination(new Currency(remainder));
		}else{
			this.chain.withdrawDenomination(cur);
		}
	}

}

