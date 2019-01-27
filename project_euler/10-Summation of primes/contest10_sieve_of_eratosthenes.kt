import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

const val MAX_N_VALUE = 1000000
val primesList:MutableList<Long> = mutableListOf(2L,3L)
val sumsCache:MutableMap<Long,Long> = mutableMapOf()
val isNotPrimeArray:BooleanArray = BooleanArray(MAX_N_VALUE)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    generateIsNotPrimeArraySupport()
    1.rangeTo(numRows).forEach{ _ ->
        println(sumPrimesBelowN(input.nextInt()))
    }
}

fun generateIsNotPrimeArraySupport(){
    for(i in 2..sqrt(MAX_N_VALUE.toDouble()).toInt()){
        for(j in i.toDouble().pow(2.0).toInt() ..  (MAX_N_VALUE-1) step i){
            isNotPrimeArray[j] = true
        }
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
    return !isNotPrimeArray[num.toInt()]
}