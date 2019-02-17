# Problem
The sequence of triangle numbers is generated by adding the natural numbers. So the 7'th triangle number would be *1 + 2 + 3 + 4 + 5 + 6 +7 = 28*. 
The first ten terms would be: *1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...*
Let us list the factors of the first seven triangle numbers:
1:1
3:1,3
6:1,2,3,6
10:1,2,5,10
15:1,3,5,15
21:1,3,7,21
28:1,2,4,7,14,28

We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over N divisors?


# Solution
To solve this problem without testcases #6 and #7 timeout it is necessary to precompute some prime numbers and to cache the results of the generated triangle numbers.
In order to generate next triangle number by the position there is a formula:

**nthTriangleNumber = n * (n-1) / 2**


## Compute the number of divisors
To compute the number of divisors I've used the [Divisor function formula](https://en.wikipedia.org/wiki/Divisor_function#Properties) in the following way:
```
fun computeNumDivisors(num:Long):Int{
    if(num == 0L) return 0
    if(num == 1L) return 1

    var numDivisors:Int = 1
    var reminder = num
    val sqrtNum = Math.sqrt(num.toDouble()).toLong()

    for(currPrime in primeNumbers){
        if(currPrime > reminder || reminder == 1L){
            break
        }
        val (numTimesDivision, currReminder) = computeNumTimesDivisionsAndReminder(reminder, currPrime)
        reminder = currReminder
        numDivisors*=(numTimesDivision+1)
    }
    for(candidatePrime in (primeNumbers.last()+2) .. sqrtNum step 2){ //+2 since pair numbers are already taken in account before
        if(isPrime(candidatePrime)){
            primeNumbers.plus(candidatePrime)
            val (numTimesDivision, currReminder) = computeNumTimesDivisionsAndReminder(reminder, candidatePrime)
            reminder = currReminder
            numDivisors*=(numTimesDivision+1)
        }
    }
    if(reminder != 1L){
        primeNumbers.plus(reminder)
        numDivisors+=2 //num^1 -> numDivisors *= (1+1)
    }
    return numDivisors
}
```
First compute the num divisors against each prime I have in my primes cache. 
If the *remainder* from the previous divisions is != 1 it means that there are some primes missing in the cache between the 
number provided as argument and the last prime number of the cache. In that case:

for each number between the last prime number in the cache and the square root of the number passed as parameter and if it is prime apply *Divisor function formula* as before.
In the end if the reminder is still != 1 it means that the reminder is a prime number so add to primes cache and add 2 to the number of divisors