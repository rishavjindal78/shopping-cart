package com.cdk.strategy;

import java.math.BigDecimal;

public class NoDiscountCustomer implements DiscountStrategy{

	@Override
	public BigDecimal apply(BigDecimal amount) {
		return BigDecimal.valueOf(0);
	}

}
