package programmers.bracketvalidation

fun checkString(input: String): Boolean {
    val length = input.length

    for(i in 0..length-1){
        println(input.get(i))
    }
    return true
}

fun main(args: Array<String>){
    checkString("hello")
}