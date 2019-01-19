# Problem
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3,5,6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below N.

# Solution
This contest can be easily solved in the following way:

```
import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(sumMultipleOf5or3BelowN(input.nextInt()))
    }
}

fun sumMultipleOf5or3BelowN(N:Int):Int{
    return 3.rangeTo(N-1).filter{num -> isMultipleOf5or3(num)}.sum()
}

fun isMultipleOf5or3(num:Int):Boolean{
    return num % 3 == 0 || num % 5 == 0
}
```
The issue with this solution is that his complexity is O(n) that causes testcase#2 and testcase#3 to fail.
A more optimized approach is to use the aritmetic progression formula to calculate the numbers multiple of 3 
and the multiple of 5 subtracting the multiple of 15 that would be counted twice:
```
PA = (n/2)[2a + (n- 1)d] 
```
Where *n* is the number of terms, *a* is the first term and *d* is the common difference (in our case a = d)
The complexity of this solution is O(1) so all the testcase will pass (see **contest1.kt**).