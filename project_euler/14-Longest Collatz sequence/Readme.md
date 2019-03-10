# Problem
The following iterative sequence is defined for the set of positive integers:

*n = n/2 if n is even*

*n=3*n+1 if n is odd*

Using the rule above and starting with 13, we generate the following sequence:

```
13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
```

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, *<=N* produces the longest chain? If many possible such numbers are there print the maximum one.

Note: Once the chain starts the terms are allowed to go above *N*.


# Solution
To solve this problem and pass all the test cases you have to:
* use dynamic programming concepts by computing and storing intermediate results in order to avoid to compute more than one time a Collatz number.
* store already computed results in a cache to make the complexity of the solution in the best case O(1) and worst case O(n)
