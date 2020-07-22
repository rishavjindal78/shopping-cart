package com.cdk.strategy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class DiscountCalculatorStrategyTest {
	
	DiscountCalculator discountCalculator = new DiscountCalculator();
	
	TreeMap<String,BigDecimal> purchaseAmountMap = new TreeMap<String,BigDecimal>();
	
	@Before
	public void setData(){
		purchaseAmountMap.put("5K", BigDecimal.valueOf(5000));
		purchaseAmountMap.put("10K", BigDecimal.valueOf(10000));
		purchaseAmountMap.put("15K", BigDecimal.valueOf(15000));
		
		purchaseAmountMap.put("4K", BigDecimal.valueOf(4000));
		purchaseAmountMap.put("8K", BigDecimal.valueOf(8000));
		purchaseAmountMap.put("12K", BigDecimal.valueOf(12000));
		purchaseAmountMap.put("20K", BigDecimal.valueOf(20000));	
	}
	
	@Test
	public void testRegularCustomerPurchaseAmt5KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.REGULAR, purchaseAmountMap.get("5K"));
		assertThat(discountedPrice, is("5000"));
	}
	
	@Test
	public void testRegularCustomerPurchaseAmt10KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.REGULAR, purchaseAmountMap.get("10K"));
		assertThat(discountedPrice, is("9500"));
	}
	
	@Test
	public void testRegularCustomerPurchaseAmt15KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.REGULAR, purchaseAmountMap.get("15K"));
		assertThat(discountedPrice, is("13500"));
	}
	
	@Test
	public void testPremiumCustomerPurchaseAmt4KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.PREMIUM, purchaseAmountMap.get("4K"));
		assertThat(discountedPrice, is("3600"));
	}
	
	@Test
	public void testPremiumCustomerPurchaseAmt8KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.PREMIUM, purchaseAmountMap.get("8K"));
		assertThat(discountedPrice, is("7000"));
	}
	
	@Test
	public void testPremiumCustomerPurchaseAmt12KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.PREMIUM, purchaseAmountMap.get("12K"));
		assertThat(discountedPrice, is("10200"));
	}
	
	@Test
	public void testPremiumCustomerPurchaseAmt20KDiscount() {
		String discountedPrice = discountCalculator.calculateDiscount(CustomerTypes.PREMIUM, purchaseAmountMap.get("20K"));
		assertThat(discountedPrice, is("15800"));
	}
	

}
