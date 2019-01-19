import java.io.*
import java.util.*

val MIN_3_DIGIT_DIVISOR = 100
val MAX_3_DIGIT_DIVISOR = 999

//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest palindrome made from the product of two 3-digit numbers.

fun main(args: Array<String>) {
    var maxPalindrome:Int = 0
    IntProgression.fromClosedRange(MAX_3_DIGIT_DIVISOR, MIN_3_DIGIT_DIVISOR, -1).forEach{
        firstNum -> 
            IntProgression.fromClosedRange(MAX_3_DIGIT_DIVISOR, MIN_3_DIGIT_DIVISOR, -1).forEach{
                secondNum ->
                    val prod = firstNum * secondNum
                    if(isPalindrome(prod) && prod > maxPalindrome){
                        println("$firstNum - $secondNum")
                        println(prod)
                        maxPalindrome = prod
                    }
            }
    }
    println("maxPal = $maxPalindrome")
}


fun isPalindrome(n:Int):Boolean{
    return n == n.toString().reversed().toInt()
}