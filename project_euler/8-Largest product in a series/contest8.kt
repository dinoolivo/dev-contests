import java.io.*
import java.util.*

fun main(args: Array<String>) {
  val input = Scanner(System.`in`)
  val numTestCases = input.nextInt()
  1.rangeTo(numTestCases).forEach{ _ ->
    val n = input.nextInt()
    val k = input.nextInt()
    val number = input.next() 
    println(largestProduct(n,k,number))
  }
}

fun largestProduct(n:Int,k:Int,number:String):Long{
    var prod:Long
    var maxProd:Long = 0
    for(i in 0..(n-k)){
        prod = 1L
        for(j in i..(i+k-1)){
            prod *= number[j].toString().toLong()
        }
        if(prod > maxProd){
            maxProd = prod
        }
    }
    return maxProd
}