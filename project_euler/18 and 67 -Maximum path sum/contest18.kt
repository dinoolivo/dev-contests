import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numTestCases = input.nextInt()

    (0 until numTestCases).forEach{
        val numRows = input.nextInt()
        val triangle:Array<IntArray> =(1 until numRows+1).map {rowNum ->
            (0 until rowNum).map { input.nextInt() }.toIntArray()
        }.toTypedArray()

        println(maxPathSum(triangle))
    }
}

fun maxPathSum(triangle: Array<IntArray>):Int {
    for(row in triangle.size -1 downTo 1){
        for(col in 0 until  triangle[row].size -1){
            triangle[row-1][col] += maxOf(triangle[row][col],triangle[row][col+1])
        }
    }
    return triangle[0][0]
}
