import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()


    val segmentsArr:IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0)
    val numDigits = 50
    val segmentSize = 5

    (0 until numRows).forEach { _ ->
        sumNumberSegments(input.next(), numDigits, segmentSize, segmentsArr)
    }

    println(veryLargeSumOfSegments(segmentsArr, segmentSize).substring(0,10))
}

fun sumNumberSegments(numStr:String, numDigits:Int, segmentSize:Int, segmentsArr:IntArray){
    val segments = numDigits/segmentSize
    for(segmentIndex in 0 until segments){
        val currSegment = numStr.substring(segmentIndex * segmentSize, segmentIndex * segmentSize + segmentSize)
        segmentsArr[segmentIndex]+=currSegment.toInt()
    }
}

fun veryLargeSumOfSegments(segmentsArr:IntArray, segmentSize:Int):String{
    var lastCarryOver = 0
    val sumSegments:List<String> = ((segmentsArr.size-1) downTo 0).map{ segmentIndex ->
        val currNumStr = (segmentsArr[segmentIndex] + lastCarryOver).toString()
        lastCarryOver = currNumStr.substring(0, currNumStr.length - segmentSize).toInt()
        currNumStr.substring(currNumStr.length - segmentSize, currNumStr.length)
    }.reversed()
    return lastCarryOver.toString()+sumSegments.joinToString(separator = "")
}
