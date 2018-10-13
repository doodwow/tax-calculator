package com.taxcalculator.domain.factory;

import com.taxcalculator.domain.ItemAdapter;
import com.taxcalculator.domain.ItemTaxCalculator;
import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.exception.InvalidItemException;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ItemFactory {

    public static List<Item> from(String[] inputs) {
        return Arrays.stream(inputs)
                .map(ItemFactory::from)
                .collect(Collectors.toList());
    }

    private static Item from(String input) {
    	try {
            Item item = ItemAdapter.createItemFromString(input);
            ItemTaxCalculator.applyTaxes(item);
            return item;
    	} catch (InvalidItemException iie) {
    		System.out.println(iie.getMessage());
    	}
    	return null;
    }

}
