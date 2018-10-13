package com.taxcalculator;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.taxcalculator.receipt.Receipt;

/**
 * Test class for {@link TaxCalculatorApplication}
 *
 */
class TaxCalculatorApplicationTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

    private TaxCalculatorApplication taxCalculatorApplication = new TaxCalculatorApplication();

    @Test
    void test() {

        String[] inputs = {"one book at 29.49", "one music CD at 15.99",
                "one chocolate bar at 0.75"};

        Receipt receipt = taxCalculatorApplication.generateReceipt(inputs);

        System.out.println(receipt);
        Assertions.assertEquals(new BigDecimal("9.42"), receipt.getTotalSalesTax());
        Assertions.assertEquals(new BigDecimal("55.65"), receipt.getTotalAmount());

    }

    @Test
    void test2() {

        String[] inputs = {"one imported box of chocolates at 10.00",
                "one imported bottle of perfume at 47.50"};

        Receipt receipt = new TaxCalculatorApplication().generateReceipt(inputs);
        System.out.println(receipt);
        Assertions.assertEquals(new BigDecimal("10.10"), receipt.getTotalSalesTax());
        Assertions.assertEquals(new BigDecimal("67.60"), receipt.getTotalAmount());
    }


    @Test
    void test3() {

        String[] inputs = {"one bottle of wine at 20.99",
                "one box of tooth ache pills at 4.15",
                "one box of pins at 11.25",
                "one music CD at 14.99"};

        Receipt receipt = new TaxCalculatorApplication().generateReceipt(inputs);
        System.out.println(receipt);
        Assertions.assertEquals(new BigDecimal("9.62"), receipt.getTotalSalesTax());
        Assertions.assertEquals(new BigDecimal("61.00"), receipt.getTotalAmount());

    }
    
    @Test
    void testChristmasShoppingList() {

        String[] inputs = {"one partridge in a pear tree at 20.99",
                "Two turtle doves at 4.15",
                "Three french hens at 11.25",
                "Four calling birds at 14.99",
                "Five golden rings at 14.99",
                "Six geese a laying at 14.99",
                "Seven swans a swimming at 14.99",
                "Eight maids a milking at 14.99",
                "Nine ladies dancing at 14.99",
                "Ten lords a leaping at 14.99",
                "Eleven pipers piping at 14.99",
                "Twelve drummers drumming at 14.99",
                "Thirteen drummers drumming at 14.99"};

        Receipt receipt = new TaxCalculatorApplication().generateReceipt(inputs);
        System.out.println(receipt);
        Assertions.assertEquals(new BigDecimal("234.41"), receipt.getTotalSalesTax());
        Assertions.assertEquals(new BigDecimal("1571.60"), receipt.getTotalAmount());

    }
    
    @Test
    void testError() {

    	try {
			System.setOut(new PrintStream(outContent));
			System.setErr(new PrintStream(errContent));
	
	        String[] inputs = {"1 partridge in a pear tree at 20.99",
	                "Two turtle doves at foo.15",
	                "Three french hens at 11.bar"};
	
	        Receipt receipt = new TaxCalculatorApplication().generateReceipt(inputs);
	        System.out.println(receipt);
	
	        InputStream inputStream = TaxCalculatorApplicationTest.class.getResourceAsStream("/testOutput.txt");
			byte[] data = new byte[(int) inputStream.available()];
			inputStream.read(data);
			inputStream.close();

			String str = new String(data, "UTF-8");
			assertEquals(str, outContent.toString());
			
			System.setOut(originalOut);
			System.setErr(originalErr);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
