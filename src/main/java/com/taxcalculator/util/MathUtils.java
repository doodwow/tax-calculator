package com.taxcalculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtils {
    
    public static BigDecimal roundOffTax(BigDecimal number) {
    	BigDecimal taxedItem = number.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);
		taxedItem = taxedItem.divide(new BigDecimal("20"), RoundingMode.UP);
		return taxedItem;
    }
}
