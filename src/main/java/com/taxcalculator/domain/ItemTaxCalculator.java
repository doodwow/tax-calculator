package com.taxcalculator.domain;

import java.math.BigDecimal;

import com.taxcalculator.domain.entities.Item;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemTaxCalculator {
	private static final BigDecimal SALES_TAX_PERCENT = new BigDecimal("0.175");
	private static final BigDecimal ADDITIONAL_SALES_TAX_FLAT_AMOUNT = new BigDecimal("1.25");

	public static void applyTaxes(Item item) {
        if (!item.isExempted()) {
            item.setBasicSalesTaxAmount(SALES_TAX_PERCENT);
        }
        
        if(item.isFixedAmtTaxed()) {
        	item.setAdditionalFlatTaxAmount(ADDITIONAL_SALES_TAX_FLAT_AMOUNT);
        }
    }
}
