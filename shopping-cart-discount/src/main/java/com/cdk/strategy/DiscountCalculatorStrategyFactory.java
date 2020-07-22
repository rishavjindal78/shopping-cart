package com.cdk.strategy;

public class DiscountCalculatorStrategyFactory {

	private final DiscountStrategy regularCustomer = new RegularCustomer();

	private final DiscountStrategy premiumCustomer = new PremiumCustomer();
	
	private final DiscountStrategy noDiscountCustomer = new NoDiscountCustomer();



	public DiscountStrategy getDiscountCalculatorStrategy(CustomerTypes customerType) {

		switch(customerType) {
			case REGULAR: return regularCustomer;
			case PREMIUM: return premiumCustomer;
			default: return noDiscountCustomer;
		}
	}


}
