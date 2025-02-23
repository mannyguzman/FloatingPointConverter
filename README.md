# FloatingPointConverter
This calculator convert decimal numbers to a binary floating point number in IEEE-754

Instructions when running:
Just write any decimal number and it will display the number in IEEE-754 format.
The program will run only once for each conversion.

### Example Console Run:

Write decimal number to convert: 

25.1

Bits of Whole number: [1, 1, 0, 0, 1]

Bits of Decimal number: [0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1]

Exponent = 4

Exponent Excess 127 = 131

Binary of 131 = 10000011

Merged Array :[1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1]

23 bit Mantissa
10010001100110011001100


Final Result

Sign - Exponent - Mantissa

0 10000011 10010001100110011001100
