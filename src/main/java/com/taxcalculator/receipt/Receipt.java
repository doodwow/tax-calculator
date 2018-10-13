package com.taxcalculator.receipt;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.taxcalculator.domain.entities.Item;

public class Receipt {
    private BigDecimal totalSalesTax = BigDecimal.ZERO;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private String itemDetails;

    public Receipt(List<Item> items) {
        itemDetails = items.stream()
        	.map(i -> i.toString())
        	.collect(Collectors.joining("\n"));
        totalAmount = items.stream().map(Item::getFinalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        totalSalesTax = items.stream().map(Item::getTaxAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getTotalSalesTax() {
        return totalSalesTax;
    }

    @Override
    public String toString() {
        return "Receipt" + "\n"
                + itemDetails + "\n"
                + "Sales Taxes: " + totalSalesTax + "\n"
                + "Total: " + totalAmount
                +"\n*******************************\n";
    }
}
