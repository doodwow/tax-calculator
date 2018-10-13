package com.taxcalculator.receipt;

import java.math.BigDecimal;
import java.util.List;

import com.taxcalculator.domain.entities.Item;

public class Receipt {
    private BigDecimal totalSalesTax = BigDecimal.ZERO;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private String itemDetails = "";

    public Receipt(List<Item> items) {
        items.stream()
        .filter(i -> i != null)
        .forEach(i -> buildReceipt(i));
    }
    
    private void buildReceipt(Item item) {
    	itemDetails += item.toString() + "\n";
    	totalAmount = totalAmount.add(item.getFinalPrice());
    	totalSalesTax = totalSalesTax.add(item.getTaxAmount());
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
