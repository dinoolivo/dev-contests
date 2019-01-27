import java.util.*

val NOT_FOUND:Int = -1

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val numTestCases = input.nextInt()
    1.rangeTo(numTestCases).forEach{ _ ->
        println(findSpecialPythagoreanTriplet(input.nextInt()))
    }
}

/*
c = N - a - b
b = (N (2a - N)) / (2 (a - N))
*/
fun findSpecialPythagoreanTriplet(num:Int):Int{
    var maxProduct = NOT_FOUND;
    for(a in 1..(num/3)){
        val bNum = num * ( num - 2 * a)
        val bDen =  2 * (num - a)
        if(bNum % bDen == 0) {
            val b = bNum / bDen
            val c = num - a - b
            val prod = a * b * c
            if(prod > maxProduct){
                maxProduct = prod
            }
        }
    }
    return maxProduct
}