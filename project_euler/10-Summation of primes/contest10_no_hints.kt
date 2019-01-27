import java.io.*
import java.util.*

val primesList:MutableList<Long> = mutableListOf(2L,3L)
val sumsCache:MutableMap<Long,Long> = mutableMapOf()

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(sumPrimesBelowN(input.nextInt()))
    }
}

fun sumPrimesBelowN(n:Int):Long{
    var currNumber:Long = primesList.last()
    var sum:Long
    if(currNumber >= n){
        val lastPrime = primesList.findLast { it <= n }
        return sumsCache.getOrPut(lastPrime!!){primesList.takeWhile  { it <= n}.sum()}
    }else{
        sum = sumsCache.getOrPut(currNumber){primesList.sum()}
        currNumber += 2
        while(currNumber <= n){
            if(isPrime(currNumber)){
                primesList.add(currNumber)
                sum += currNumber
				sumsCache[currNumber] = sum
            }
            currNumber += 2
        }
    }
    return sum
}

fun isPrime(num:Long):Boolean{
    val sqrtN = Math.sqrt(num.toDouble())
    for(prime in primesList){
        if(num % prime == 0L) return false
        if(prime > sqrtN) return true
    }
    return true
}