import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numRows = input.nextInt()
    1.rangeTo(numRows).forEach{ _ ->
        println(sumEvenFibonacciNumbers(input.nextLong()))
    }
}

fun sumEvenFibonacciNumbers(num:Long):Long{
    var fibEvenIndex = 0
    var fibNum:Long = 0
    var sumEvenFibs:Long = 0
    do{
        sumEvenFibs += fibNum
        fibNum = fib(fibEvenIndex)
        fibEvenIndex+=3
    }while(fibNum < num);
    
    return sumEvenFibs
}

fun fib(n:Int):Long{
    var first:Long = 0
    var second:Long = 1
    var sum:Long
    return if(n == 0){
        0
    }else if(n ==1){
        1
    }else{
        for(i in 2..n){
            sum = first + second
            first = second
            second = sum
        }
        return second
    }
}