package com.sachin;

/**
* @author sachin
* @date 15-Sep-2021
*/

public interface DenominationChain {
	
	public void setNextChain(DenominationChain next);
	
	public void withdrawDenomination(Currency cur);

}


