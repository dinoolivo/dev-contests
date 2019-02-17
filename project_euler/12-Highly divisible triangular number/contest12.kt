import java.util.*

val primeNumbers = arrayOf( 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L,
    47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L, 101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L, 139L,
    149L, 151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L, 197L, 199L, 211, 223, 227, 229, 233, 239, 241, 251, 257,
    263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401,
    409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541
)
val triangleNumbersCache = arrayOfNulls<Long?>(1000)
var lastComputedTriangleNumberPosition:Int?=null

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numTestCases = input.nextInt()
    (0 until numTestCases).forEach { _ ->
        println(findFirstTriangularNumberWithNDivisors(input.nextInt()))
    }
}


fun findFirstTriangularNumberWithNDivisors(numDivisors:Int):Long{
    var nthPosition:Int = lastComputedTriangleNumberPosition?:3
    var lastComputed:Long
    var currNumDivisors:Int


    if(triangleNumbersCache[numDivisors-1] != null){
        return triangleNumbersCache[numDivisors-1]!!
    }

    do{
        lastComputed =  nthTriangleNumber(nthPosition++)
        currNumDivisors = computeNumDivisors(lastComputed)
        updateCache(currNumDivisors, lastComputed)
    }while (currNumDivisors <= numDivisors)

    lastComputedTriangleNumberPosition = nthPosition

    return lastComputed
}

fun updateCache(maxPosition: Int, value:Long){
    var currPosition = if(maxPosition - 2 > triangleNumbersCache.size-1) triangleNumbersCache.size-1 else maxPosition -2
    while(currPosition >= 0 && triangleNumbersCache[currPosition] == null)
        triangleNumbersCache[currPosition--] = value
}

fun nthTriangleNumber(n:Int):Long{
    return n.toLong() * (n-1) / 2
}

fun computeNumDivisors(num:Long):Int{
    if(num == 0L) return 0
    if(num == 1L) return 1

    var numDivisors:Int = 1
    var reminder = num
    val sqrtNum = Math.sqrt(num.toDouble()).toLong()

    for(currPrime in primeNumbers){
        if(currPrime > reminder || reminder == 1L){
            break
        }
        val (numTimesDivision, currReminder) = computeNumTimesDivisionsAndReminder(reminder, currPrime)
        reminder = currReminder
        numDivisors*=(numTimesDivision+1)
    }
    for(candidatePrime in (primeNumbers.last()+2) .. sqrtNum step 2){ //+2 since pair numbers are already taken in account before
        if(isPrime(candidatePrime)){
            primeNumbers.plus(candidatePrime)
            val (numTimesDivision, currReminder) = computeNumTimesDivisionsAndReminder(reminder, candidatePrime)
            reminder = currReminder
            numDivisors*=(numTimesDivision+1)
        }
    }
    if(reminder != 1L){
        primeNumbers.plus(reminder)
        numDivisors+=2 //num^1 -> numDivisors *= (1+1)
    }
    return numDivisors
}

fun computeNumTimesDivisionsAndReminder(currNumber:Long, primeNumber:Long):Pair<Int,Long>{
    var reminder = currNumber
    var numTimesDivision = 0

    while (reminder % primeNumber == 0L) {
        numTimesDivision++
        reminder /= primeNumber
    }
    return Pair(numTimesDivision, reminder)
}

fun isPrime(num:Long):Boolean{
    return primeNumbers.firstOrNull { currPrime -> num % currPrime != 0L } == null
}
