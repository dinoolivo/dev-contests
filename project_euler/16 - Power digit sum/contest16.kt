import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numTestCases = input.nextInt()

    (0 until numTestCases).forEach{
        println(powerAndDigitSum(input.nextInt()))
    }
}

fun powerAndDigitSum(n:Int):Int{
    return BigInteger.valueOf(2).pow(n).toString().map(Character::getNumericValue).sum()
}
