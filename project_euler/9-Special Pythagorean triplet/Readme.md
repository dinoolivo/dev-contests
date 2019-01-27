# Problem
A Pythagorean triplet is a set of three natural numbers *a < b < c*, , for which,

*a<sup>2</sup>+b<sup>2</sup> = c<sup>2</sup>*

For example, *3<sup>2</sup>+4<sup>2</sup> = 9 + 16 = 25 = 5<sup>2</sup>*

Given *N*, Check if there exists any Pythagorean triplet for which *a + b + c = N*

Find maximum possible value of *abc* among all such Pythagorean triplets, If there is no such Pythagorean triplet print *-1*.

# Solution
A solution with complexity O(N) can be found by doing a bit of math. We know that:

* *a<sup>2</sup>+b<sup>2</sup> = c<sup>2</sup>*
* *a + b + c = N*

from these two equations we can find that:
* c = N - a - b
* b = (N * (2*a - N)) / (2 * (a - N))

*N.B: Pay attention that the request is **Find maximum possible value of *abc* among all such Pythagorean triplets** 
so you have to iterate for all the triplets in order to find the one with the greatest product.* 