# Tax Calculator

Taxes are calculated with a rate of 17.5%, rounding the result to the upper 0.05. Please note that medical products are exempt from taxes and an additional 1.25 fixed amount is added as an extra tax on CDs.

When I purchase items I receive a receipt which lists the name of all the
items and their price (including tax), finishing with the total cost of the
items, and the total amounts of sales taxes paid.  The rounding rules for
sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details ...

**Input 1:**  
one book at 29.49
one music CD at 15.99
one chocolate snack at 0.75

**Output 1:**  
1 book: 34.65
1 music CD: 20.05
1 chocolate snack: 0.90
Sales Taxes: 9.37
Total: 55.59 
***
**Input 2:**  
one bottle of wine at 20.99
one box of tooth ache pills at 4.15 one box of pins at 11.25
one music CD at 14.99

**Output 2:**  
1 bottle of wine: 24.65
1 box of headache pills: 4.15
1 box of pins: 13.20
1 music CD: 18.85
Sales Taxes: 9.37
Total: 60.85
***

Shout-out to the person (https://www.linkedin.com/in/ankit-soni-06147280/) who wrote much of this. 