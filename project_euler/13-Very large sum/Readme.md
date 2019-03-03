# Problem
Work out the first ten digits of the sum of *N50-digits* numbers.


# Solution
A solution can be to divide the 50 digits number in segments and sum each segment with the corresponding one of the number to sum.
In the end the lastCarryOver is computed for each segment and added to the previous segment then the first 10 digits substring is taken from the result. (*contest13_segments.kt*)

Or simply you can discover the BigInteger class and just iterate over the 50 digit numbers by performing a simple add since 
** There is no theoretical limit. The BigInteger class allocates as much memory as it needs for all the bits of data it is asked to hold.
There are, however, some practical limits, dictated by the memory available. And there are further technical limits, although you're very unlikely to be affected: 
some methods assume that the bits are addressable by int indexes, so things will start to break when you go above Integer.MAX_VALUE bits.**
(*contest13_big_integer.kt*)
