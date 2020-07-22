package com.cdk.strategy;

import java.math.BigDecimal;

public class DiscountCalculator {

	private final DiscountCalculatorStrategyFactory discountCalculatorStrategyFactory = new DiscountCalculatorStrategyFactory();

	public String calculateDiscount(CustomerTypes customerType, BigDecimal purchaseAmt) {

		DiscountStrategy discountCalculatorStrategy =  discountCalculatorStrategyFactory.getDiscountCalculatorStrategy(customerType);

		return purchaseAmt.subtract(discountCalculatorStrategy.apply(purchaseAmt)).stripTrailingZeros().toPlainString();

	}

}
