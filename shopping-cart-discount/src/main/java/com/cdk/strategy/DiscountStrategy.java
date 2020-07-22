package com.cdk.strategy;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface DiscountStrategy extends UnaryOperator<BigDecimal> {
	
	static <T extends Comparable<T>> boolean isBetween(T x, T lowerBound, T upperBound) {
	    return x.compareTo(lowerBound) > 0 && x.compareTo(upperBound) <= 0;
	}

}
