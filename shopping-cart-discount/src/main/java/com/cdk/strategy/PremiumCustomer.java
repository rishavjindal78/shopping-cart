package com.cdk.strategy;

import java.math.BigDecimal;
import static com.cdk.strategy.Constants.*;

public class PremiumCustomer implements DiscountStrategy{

	@Override
	public BigDecimal apply(BigDecimal purchaseAmt) {
		BigDecimal discountedPrice = new BigDecimal("0");

		if(purchaseAmt.compareTo(BigDecimal.valueOf(4000)) <= 0) {
			discountedPrice = tenPer.multiply(purchaseAmt);
		} else if(DiscountStrategy.isBetween(purchaseAmt,BigDecimal.valueOf(4000),BigDecimal.valueOf(8000))) {
			discountedPrice = fifteenPer.multiply(purchaseAmt.subtract(BigDecimal.valueOf(4000))).add(tenPer.multiply(BigDecimal.valueOf(4000)));
		} else if(DiscountStrategy.isBetween(purchaseAmt,BigDecimal.valueOf(8000),BigDecimal.valueOf(12000))) {
			discountedPrice = twentyPer.multiply(purchaseAmt.subtract(BigDecimal.valueOf(8000))).add(fifteenPer.multiply(BigDecimal.valueOf(4000))).add(tenPer.multiply(BigDecimal.valueOf(4000)));
		} else if(purchaseAmt.compareTo(BigDecimal.valueOf(12000)) > 0) {
			discountedPrice = thirtyPer.multiply(purchaseAmt.subtract(BigDecimal.valueOf(12000))).add(twentyPer.multiply(BigDecimal.valueOf(4000))).add(fifteenPer.multiply(BigDecimal.valueOf(4000))).add(tenPer.multiply(BigDecimal.valueOf(4000)));
		}
		
		return discountedPrice;
	}

}
