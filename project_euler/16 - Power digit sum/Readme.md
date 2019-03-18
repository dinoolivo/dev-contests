# Problem
2<sup>9</sup> = 512 and the sum of its digits is 5 + 1 + 2 = 8.
What is the sum of the digits of the number 2<sup>N</sup>?


# Solution
The solution is pretty straightforward: using bigInteger you can compute 2<sup>N</sup> then stringify the solution and for every character take the corresponding int 
value and sum (just pay attention to use *Character::getNumericValue* and not *toInt()* otherwise you will get the ascii int value for that character)
