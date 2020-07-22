package com.cdk.strategy;

import java.math.BigDecimal;
import static com.cdk.strategy.Constants.*;
public class RegularCustomer implements DiscountStrategy {

	@Override
	public BigDecimal apply(BigDecimal purchaseAmt) {
		
		BigDecimal discountedPrice = new BigDecimal("0");

		if(DiscountStrategy.isBetween(purchaseAmt,BigDecimal.valueOf(5000),BigDecimal.valueOf(10000))) {
			discountedPrice = (purchaseAmt.subtract(BigDecimal.valueOf(5000))).multiply(tenPer);
		} else if(purchaseAmt.compareTo(BigDecimal.valueOf(10000)) > 0) {
			discountedPrice = (purchaseAmt.subtract(BigDecimal.valueOf(10000))).multiply(twentyPer).add(BigDecimal.valueOf(5000).multiply(tenPer));
		}
		
		return discountedPrice;
	}

}
