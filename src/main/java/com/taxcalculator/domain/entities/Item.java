package com.taxcalculator.domain.entities;

import com.taxcalculator.util.MathUtils;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Item {

    private String name;
    
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal basePrice = BigDecimal.ZERO;
    private BigDecimal basicSalesTaxAmount = BigDecimal.ZERO;
    private BigDecimal flatTaxAmount = BigDecimal.ZERO;
    private BigDecimal finalPrice = BigDecimal.ZERO;

    public Item(Long quantity, String name, String basePrice) {
        this.name = name.trim();
        this.quantity = new BigDecimal(quantity);
        this.basePrice = new BigDecimal(basePrice);
    }

    public BigDecimal getFinalPrice() {
        finalPrice = MathUtils.roundOffTax((basePrice.multiply(quantity.add(basicSalesTaxAmount)).add(flatTaxAmount)));
        return finalPrice;
    }

    public BigDecimal getTaxAmount() {
        return finalPrice.subtract(basePrice.multiply(quantity));
    }

    public boolean isImported() {
        return name.contains("imported");
    }

    public boolean isExempted() {
        return Stream.of("pill")
                .anyMatch(exemptedItem -> name.contains(exemptedItem));
    }
    
    public boolean isFixedAmtTaxed() {
    	return (name.contains("CD")) ? true : false;
    }

    public void setBasicSalesTaxAmount(BigDecimal basicSalesTaxPercent) {
        this.basicSalesTaxAmount = basicSalesTaxPercent;
    }
    
    public void setAdditionalFlatTaxAmount(BigDecimal flatTax) { 
    	this.flatTaxAmount = flatTax;
    }

    public String toString() {
        return String.valueOf(quantity) +
                " " +
                name +
                ": " +
                getFinalPrice();
    }
}
