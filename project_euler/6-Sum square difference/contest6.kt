import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(absoluteDifference(input.nextLong()))
    }
}

fun absoluteDifference(n:Long):Long{
    return (sumFirstNnumbers(n) * sumFirstNnumbers(n)) - sumFirstNnumbersSquare(n)
}

//calculate the sum of first n numbers with gauss formula
fun sumFirstNnumbers(n:Long):Long{
    return (n*(n+1L))/2L
}

fun sumFirstNnumbersSquare(n:Long):Long{
    return (n * (n+1L) * (2*n+1L))/6L
}