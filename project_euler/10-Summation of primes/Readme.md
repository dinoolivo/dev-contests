# Problem
The sum of the primes below *10* is *2 + 3 + 5 + 7 = 17*.

Find the sum of all the primes not greater than given *N*.

# Solution
The solution is similar to problem #7 but it will require a bit more of optimization in order to pass all the testcases.
The two proposed solution differs on the computation of the *isPrime* function:
* the firs solution is more general and uses an array in which all the primes number are stored 
* the second solution uses precomputation of all prime numbers lower than *1000000* using Sieve of Eratosthenes algorithm
  so it is less general but faster than first solution
Both solutions pass all the test cases 