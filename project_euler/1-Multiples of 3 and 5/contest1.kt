import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(sumMultipleOf5or3BelowN(input.nextInt()))
    }
}

//PA = (n/2)[2a + (n- 1)d]
fun sumMultipleOf5or3BelowN(N:Int):Long{
    val sumMul3 = calcPa((N-1)/3, 3, 3)
    val sumMul5 = calcPa((N-1)/5, 5, 5)
    val sumMul15 = calcPa((N-1)/15, 15, 15)
    return sumMul3 + sumMul5 - sumMul15
}

fun calcPa(n:Int, a:Int, d:Int):Long{
    return ((n.toLong() * (2 * a + (n - 1) * d))/2).toLong()
}