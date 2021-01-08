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
    var result : Boolean = true

    for(i in 0..length-1){
        var strAt = input.get(i).toString()
        if(strAt.equals(")")){
            closeBracketCnt += 1
        }
        else{
            if(closeBracketCnt > openBracketCnt){
                result = false
                break
            }
            openBracketCnt += 1
        }
    }

    if(closeBracketCnt != openBracketCnt) result = false

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
    var input9: String = "()"

    println("\n\n")
    // TODO:: 테스트코드로 이관하기
    // 이것도 테스트 코드로 이관할 예정
//    var result = solution(input8)
//    var result = solution(input1)

    var result = solution(")(")
    println("*******")
    println("result = $result")
}

/**
 * TODO:: 설명 추가 예정
 */
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

    println("input :: ${question}")
    println("나누려는 문자열의 기준 인덱스 :: ${divIndex+1}")
    println("문자열 'u', 'v'로 분리합니다... u=$u , v=$v")

    // 3. 올바른 문자열인가? 체크
    val testBracket : Boolean = checkIfOk(u)
    println("문자열 'u'는 올바른 문자열인가요? :: ${testBracket} \n\n")

    // 3. u 가 올바른 괄호 문자열이라면 문자열 v 에 대해 1단계 부터 다시 수행.
    if(testBracket == true){
        // 3-1. 문자열 v 에 대해 1단계부터 다시 수행
        return u + solution(v)
    }
    // 4. u 가 올바른 괄호 문자열이 아니라면
    else{
        // 문자열 v 에 대해 1단계 부터 재귀적으로 수행한 결과문자열을 얻는다.
        // 문자열 u의 첫번째, 마지막 문자를 제거한다
        // 문자열 u의 나머지 문자열의 괄호방향을 뒤집는다. --- a)
        // 문자열 u의 첫번째, 마지막 문자의 순서를 거꾸로 해서  a)의 문자의 양 끝에 붙인다.
        //   lastChar + a) + firstChar
        // > [lastChar + a) + firstChar] + v
        // 첫번째 u + 첫번째 v
        //          ( 두번째 u : [lastChar + a) + firstChar] +  두번째 v )

        var strippedString: String = u.substring(1, u.length-1)
        var firstChar   = u.substring(0,1)
        var lastChar    = u.substring(u.length-1, u.length)

        // var invertedString: String = strippedString.reversed() // strippedString을 뒤집는다.

        val charArray : CharArray= strippedString.toCharArray()

        for(i in charArray.indices){
            if(charArray[i].equals('(')){
                charArray[i] = ')'
            }
            else{
                charArray[i] = ')'
            }
        }

        var invertedString: String = String(charArray) // strippedString 을 뒤집은 문자열
        var uResult = lastChar + invertedString + firstChar
        var vResult = solution(v)
        return uResult + vResult
    }
}