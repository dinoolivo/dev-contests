# Problem
By listing the first six prime numbers: 2, 5, 7, 11 and 13, we can see that the *6<sup>th</sup>* prime is 13. 
What is the *N<sup>th</sup>* prime number?

# Solution
1. Add to the stack the first 10 prime numbers: 2L,3L,5L,7L,11L,13L,17L,19L,23L,29L
2. if n < stack size then return stack[n-1] (the stack first index is 0)
3. if n > stack size look for the next prime number and add it to the stack until its size reaches n.

To find the next prime number loop from the last found prime number adding 1 and check if it is prime against the stack:
if the module against one of the elements of the stack is 0 then is not prime otherwise it is prime.