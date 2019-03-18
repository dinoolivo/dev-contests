import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numTestCases = input.nextInt()
    val mod = BigInteger.valueOf(1000000007)
    (0 until numTestCases).forEach{
        println(latticePaths(input.nextInt(), input.nextInt()) % mod)
    }
}

/*
Use lattice path formula (n+k n) => (n+k)!/(n!k!)
*/
fun latticePaths(rows: Int, cols: Int):BigInteger{
    return factorial(rows+cols) / (factorial(rows) * factorial(cols))
}

fun factorial(n:Int):BigInteger{
    return if(n == 1){
        BigInteger.valueOf(1)
    }else{
        factorial(n-1).multiply(n.toBigInteger())
    }
}

/**
 * Solution without lattice paths with recursion
 */
fun numPathsOnMatrix(rows: Int, cols: Int): Long {

    val matrixRows = rows * 2  + 1
    val matrixCols = cols * 2  + 1

    val matrix:Array<IntArray> = Array(matrixRows) {IntArray(matrixCols)}
    for(row in 0 until matrixRows){
        for(col in 0 until matrixCols){
            if(row % 2 == 0 || col %2 == 0)
                matrix[row][col] = 1
        }
    }
    return calculateNumPaths(matrix, 0, 0)
}

fun calculateNumPaths(matrix:Array<IntArray>, row:Int, col:Int):Long{

   var count = 0L
    //printMatrix(matrix)
   if(row == matrix.size-1 && col == matrix[0].size -1){
       return 1L
   }
   if(row+1 < matrix.size && matrix[row+1][col] == 1){
       matrix[row+1][col] = 2
       count += calculateNumPaths(matrix, row+1, col)
       matrix[row+1][col] = 1
   }
   if(col+1 < matrix[0].size && matrix[row][col+1] == 1){
       matrix[row][col+1] = 2
       count+= calculateNumPaths(matrix, row, col+1)
       matrix[row][col+1] = 1
   }
   return count
}
