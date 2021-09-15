package com.sachin;

/**
* @author sachin
* @date 15-Sep-2021
*/

public class DenominationChainConfig {
	
	static TwentyDollarDenomination twenty = new TwentyDollarDenomination();
	static TenDollarDenomination ten = new TenDollarDenomination();
	static FiveDollarDenomination five = new FiveDollarDenomination();
	static OneDollarDenomination one = new OneDollarDenomination();
	
	public static DenominationChain getDollarDenominationChain() {
		twenty.setNextChain(ten);
		ten.setNextChain(five);
		five.setNextChain(one);
		return twenty;
	}

}


