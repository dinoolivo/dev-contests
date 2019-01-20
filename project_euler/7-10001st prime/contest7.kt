import java.io.*
import java.util.*

val primesList:MutableList<Long> = mutableListOf(2L,3L,5L,7L,11L,13L,17L,19L,23L,29L)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(nthPrimeGenerator(input.nextInt()))
    }
}

fun nthPrimeGenerator(n:Int):Long{
    var currNumber:Long
    while(n > primesList.size){
       currNumber = primesList.last() + 1
       while(!isPrime(currNumber++)){}
       primesList.add(currNumber-1)
    }
    return primesList[n-1]
}

fun isPrime(num:Long):Boolean{
    for(currPrime in primesList){
      if(num % currPrime == 0L) return false
    }
    return true
}