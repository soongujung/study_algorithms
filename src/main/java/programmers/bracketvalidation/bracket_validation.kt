package programmers.bracketvalidation

// kotlin 에서 string 을 순회하는 방식에 대해 헷갈려서 테스트
fun checkString(input: String): Boolean {
    val length = input.length

    for(i in 0..length-1){
        println(input.get(i))
    }
    return true
}

// 균형잡힌 문자열로 분리
// return 값이 0 이면 비정상적인 괄호문자열이라는 의미
fun divideIntoBalancedIndex(input: String) : Int {

    var result: Int = 0
    var cnt_left_bracket = 0
    var cnt_right_bracket = 0

    for(i in 0 until input.length){
        var char = input[i].toString()

        if("(".equals(char)){
            cnt_left_bracket++
        }
        else{
            cnt_right_bracket++
        }

        if(cnt_left_bracket == cnt_right_bracket){
            result = i
            break;
        }
    }

    return result
}

// 올바른 괄호문자열 체크
// 닫는 괄호의 갯수가 여는 괄호의 갯수보다 많으면 비정상적인 괄호문자열이다.
fun checkIfOk(input: String): Boolean {
    val length = input.length
    var openBracketCnt : Int = 0
    var closeBracketCnt : Int = 0
    var result : Boolean = false

    for(i in 0..length-1){
        var strAt = input.get(i).toString()
        if(strAt.equals(")")){
            openBracketCnt = openBracketCnt + 1
        }
        else{
            if(closeBracketCnt > openBracketCnt){
                break
            }
            closeBracketCnt = closeBracketCnt + 1
        }
    }

    return result
}

fun main(args: Array<String>){
    // 입력값 모음
    val input1: String = "()))((()"
    val input2: String = "()))(("
    val input3: String = "()))("
    val input4: String = "()))"
    val input5: String = "())"
    var input6: String = "((()))"
    var input7: String = "((())"
    var input8: String = "(()"

    // 테스트
//    testBracketBalancedIndex()
//    println("")
//    testCheckIfOk()

    solution(input8)
}

fun solution (question : String) : String{
    var result: String = ""

    // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if(question.length == 0){
        return ""
    }

    // 2. 문자열 w를 균형잡힌 문자열 u, v 로 분리
    val divIndex = divideIntoBalancedIndex(question)
    var u = question.substring(0, divIndex+1)
    var v = question.substring(divIndex+1, question.length)

    println("split Index :: ${divIndex+1}")
    println("input :: ${question}")
    println("u :: ${u}")
    println("v :: ${v}")

    // 3. 올바른 문자열인가? 체크
    val testBracket : Boolean = checkIfOk(u)
    println("올바른 문자열인가요? :: ${testBracket}")
    

    return result
}

fun testBracketBalancedIndex() : Unit{
    val input1: String = "()))((()"
    val input2: String = "()))(("
    val input3: String = "()))("
    val input4: String = "()))"
    val input5: String = "())"
    var input6: String = "((()))"
    var input7: String = "((())"
    var input8: String = "(()"

    val result1 = divideIntoBalancedIndex(input1)
    val result2 = divideIntoBalancedIndex(input2)
    val result3 = divideIntoBalancedIndex(input3)
    val result4 = divideIntoBalancedIndex(input4)
    val result5 = divideIntoBalancedIndex(input5)
    val result6 = divideIntoBalancedIndex(input6)
    val result7 = divideIntoBalancedIndex(input7)
    val result8 = divideIntoBalancedIndex(input8)

    println("bracket index #1 :: ${result1}")
    println("bracket index #2 :: ${result2}")
    println("bracket index #3 :: ${result3}")
    println("bracket index #4 :: ${result4}")
    println("bracket index #5 :: ${result5}")
    println("bracket index #6 :: ${result6}")
    println("bracket index #7 :: ${result7}")
    println("bracket index #8 :: ${result8}")
}

fun testCheckIfOk(){
    val input1: String = "()))((()"
    val input2: String = "()))(("
    val input3: String = "()))("
    val input4: String = "()))"
    val input5: String = "())"

    val test1 = checkIfOk(input1)
    println("test #1 :: ${test1}")

    val test2 = checkIfOk(input2)
    println("test #2 :: ${test2}")

    val test3 = checkIfOk(input3)
    println("test #3 :: ${test3}")

    val test4 = checkIfOk(input4)
    println("test #4 :: ${test4}")

    val test5 = checkIfOk(input5)
    println("test #5 :: ${test5}")
}