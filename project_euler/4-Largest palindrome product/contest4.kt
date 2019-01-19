import java.io.*
import java.util.*

val MIN_VAL_N = 101101
val MIN_3_DIGIT_DIVISOR = 100
val MAX_3_DIGIT_DIVISOR = 999

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(largestPalindrome(input.nextInt()))
    }
}

fun largestPalindrome(startNum:Int):Int{
    var n = startNum-1; //found number should be less than N
    while(n >= MIN_VAL_N){
        if(isPalindrome(n) && has3DigitDivisors(n)){
            return n
        }
        n--
    }
    return 0
}

fun isPalindrome(n:Int):Boolean{
    return n == n.toString().reversed().toInt()
}

fun has3DigitDivisors(n:Int):Boolean{
    MIN_3_DIGIT_DIVISOR.rangeTo(MAX_3_DIGIT_DIVISOR).forEach{ divisor -> 
        if(n % divisor == 0){
            var other = n/divisor
            if(other >= MIN_3_DIGIT_DIVISOR && other <= MAX_3_DIGIT_DIVISOR) return true
        }
    }
    return false
}