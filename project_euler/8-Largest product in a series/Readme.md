# Problem
Find the greatest product of *K* consecutive digits in the *N* digit number.

# Solution
Consider the number as a string and make the products in a sliding window. At the end of each loop compare the product with the maxProduct until that moment
and if it is greater maxProduct = currentProduct. The solution is *O(n<sup>2</sup>)* 