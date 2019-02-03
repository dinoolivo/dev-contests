import java.util.*


fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = 20
    val matrix:Array<IntArray> = arrayOfNulls<IntArray?>(numRows) as Array<IntArray>

    (0 until numRows).forEach{row ->
        val rowArr = IntArray(numRows)
        (0 until numRows).forEach{col ->
            rowArr[col] = input.nextInt()
        }
        matrix[row] = rowArr
    }
    println(maxProductInMatrix(4, matrix))

}

fun maxProductInMatrix(numAdjacentNumbers:Int, matrix:Array<IntArray>):Int{
    var maxProduct = 0
    var currProduct:Int
    for(i in 0 until matrix.size){
        for(j in 0 until matrix.size) {
            currProduct = maxOf(
                prodRight(j, i, numAdjacentNumbers, matrix),
                prodDown(j, i, numAdjacentNumbers, matrix),
                maxOf(prodDiagonalLeft(j, i, numAdjacentNumbers, matrix), prodDiagonalRight(j, i, numAdjacentNumbers, matrix))
            )
            if (currProduct > maxProduct)
                maxProduct = currProduct
        }
    }
    return maxProduct
}


fun prodRight(x:Int, y:Int, numAdjacentNumbers:Int, matrix:Array<IntArray>):Int{
    if(x + numAdjacentNumbers > matrix.size) return 0
    var product = 1
    for(i in x until x + numAdjacentNumbers){
        product *= matrix[y][i]
    }
    return  product
}

fun prodDown(x:Int, y:Int, numAdjacentNumbers:Int, matrix:Array<IntArray>):Int{
    if(y + numAdjacentNumbers > matrix.size) return 0
    var product = 1
    for(i in y until y + numAdjacentNumbers){
        product *= matrix[i][x]
    }
    return  product
}

fun prodDiagonalRight(x:Int, y:Int, numAdjacentNumbers:Int, matrix:Array<IntArray>):Int{
    if(maxOf(x+numAdjacentNumbers, y+numAdjacentNumbers) > matrix.size) return 0
    var product = 1
    for(i in 0 until numAdjacentNumbers){
        product *= matrix[y+i][x+i]
    }
    return  product
}

fun prodDiagonalLeft(x:Int, y:Int, numAdjacentNumbers:Int, matrix:Array<IntArray>):Int{
    if(x-numAdjacentNumbers <0 || y+numAdjacentNumbers > matrix.size) return 0
    var product = 1
    for(i in 0 until numAdjacentNumbers){
        product *= matrix[y+i][x-i]
    }
    return  product
}

