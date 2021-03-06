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
Receipt
1 book  : 34.70
1 music CD  : 20.05
1 chocolate bar  : 0.90
Sales Taxes: 9.42
Total: 55.65
*******************************
***
**Input 2:**  
one bottle of wine at 20.99
one box of tooth ache pills at 4.15
one box of pins at 11.25
one music CD at 14.99

**Output 2:**  
Receipt
1 bottle of wine  : 24.70
1 box of tooth ache pills  : 4.15
1 box of pins  : 13.25
1 music CD  : 18.90
Sales Taxes: 9.62
Total: 61.00
*******************************
***

Shout-out to the person who did this (https://github.com/ankitprahladsoni/tax_calculator) whose template I used. 