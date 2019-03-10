import java.util.*


fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numTestCases = input.nextInt()

    val cacheSize = 5 * Math.pow(10.0,6.0).toInt() +1
    val collatzSequenceNumMembers = IntArray(cacheSize)
    collatzSequenceNumMembers[0] = 0
    collatzSequenceNumMembers[1] = 1
    collatzSequenceNumMembers[2] = 1


    val computedCache = arrayOfNulls<Pair<Int,Int>>(cacheSize)

    (0 until numTestCases).forEach{
        println(numWithlongestCollatzSequenceLessThan(input.nextInt(), collatzSequenceNumMembers, computedCache))
    }
}

/*
* Return the number less than num with the higher collatz chain. If more than one number
* have the same number of elements into the chain returns the one with the greater n
* */
fun numWithlongestCollatzSequenceLessThan(num: Int, collatzCache: IntArray, computedCache:Array<Pair<Int,Int>?>):Int {
    if(computedCache[num] != null){
        return computedCache[num]!!.first
    }
    val alreadyComputed = findFirstComputedLessThanN(computedCache, num)
    var max = alreadyComputed
    for(n in (alreadyComputed.first+1)..num){
        val count = numThermsCollatzSequence(n.toLong(), collatzCache)
        if(count >= max.second){
            max = Pair(n,count)
        }
        computedCache[n] = max
    }
    return max.first
}


fun findFirstComputedLessThanN(computedCache:Array<Pair<Int,Int>?>, num:Int):Pair<Int,Int>{
    (num downTo 0).forEach{n ->
        if(computedCache[n] != null)
            return computedCache[n]!!
    }
    return Pair(2,1)
}


fun numThermsCollatzSequence(num: Long, cache:IntArray): Int {
    if(num >= cache.size || cache[num.toInt()] == 0){
        val numTherms = 1 + if(num %2 == 0L){
            numThermsCollatzSequence(num /2, cache)
        }else{
            numThermsCollatzSequence(3*num +1, cache)
        }
        if(num < cache.size)
            cache[num.toInt()] = numTherms
        else
            return numTherms
    }

    return cache[num.toInt()]

}

