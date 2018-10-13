package com.taxcalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.taxcalculator.domain.entities.Item;
import com.taxcalculator.exception.InvalidItemException;
import com.taxcalculator.exception.WordToNumberException;
import com.taxcalculator.util.WordToNumberUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemAdapter {
    private static final String ITEM_ENTRY_REGEX = "(\\w+) ([\\w\\s]* )at (\\d+.\\d{2})";

    public static Item createItemFromString(String input) throws InvalidItemException{
    	try {

            Pattern pattern = Pattern.compile(ITEM_ENTRY_REGEX);
            Matcher matcher = pattern.matcher(input);
            matcher.find();

            return new Item(WordToNumberUtils.convertWordToNumber(matcher.group(1)), matcher.group(2), matcher.group(3));
    	} catch (IllegalStateException | WordToNumberException ex) {
    		throw new InvalidItemException(input);
    	}
    }
}
