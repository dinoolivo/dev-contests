import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(findLargestPrimeFactor(input.nextLong()))
    }
}

fun findLargestPrimeFactor(targetNum:Long):Long{
    var remains:Long = targetNum
    var largestPrimeFactor:Long = 1L
    while(remains % 2 == 0L){
        remains/=2;
        largestPrimeFactor = 2L
    }
    
    val sqrtN = Math.sqrt(remains.toDouble()).toLong()
    var currFactor:Long = 3L
    while(currFactor <= sqrtN){
        if(remains % currFactor == 0L){
            remains /= currFactor;
            largestPrimeFactor = currFactor;
            continue //if is divisible by this number try several times with the same number
        }

        currFactor+=2 //all the multiple of 2 have been excluded by previous while
    }
    
    if(remains == targetNum){
        largestPrimeFactor = targetNum;
    }else if(remains > 2L) {
        largestPrimeFactor = remains;
    }
    
    return largestPrimeFactor
}