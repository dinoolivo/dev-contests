import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()


    var veryLargeSum = BigInteger("0")

    (0 until numRows).forEach { _ ->
        veryLargeSum = veryLargeSum.add(input.nextBigInteger())
    }
    println(veryLargeSum.toString().substring(0,10))
}
