import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BracketTest {

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


    @Test
    fun test():Unit{
        println("hello~")
    }

    @Test
    @DisplayName("앞뒤문자를 제거하고 문자의 괄호방향을 뒤집기 테스트해보기")
    fun testInverseStringAndStripString(): Unit {
        var input: String = ")bbb("
        var strippedString = input.substring(1, input.length-1)
        println("입출력 예 #3")
        println("strippedString = $strippedString")

        var firstChar = input.substring(0,1)
        var lastChar = input.substring(input.length-1, input.length)
        println("앞문자 =$firstChar, 뒷문자 = $lastChar")

        println("입출력 예 #2")
        input = ""
        if(input.length > 0) strippedString = input.substring(1, input.length-1)
        println("나머지 문자가 공백일때 괄호 방향을 뒤집으면 :: ${input}")
    }

    @Test
    @DisplayName("균형잡힌 문자열 구하는 함수 테스트")
    fun testBracketBalancedIndex() : Unit{
        val input1: String = "()))((()"
        val input2: String = "()))(("
        val input3: String = "()))("
        val input4: String = "()))"
        val input5: String = "())"
        var input6: String = "((()))"
        var input7: String = "((())"
        var input8: String = "(()"
        var input9: String = "()"

        val result1 = programmers.bracketvalidation.divideIntoBalancedIndex(input1)
        val result2 = programmers.bracketvalidation.divideIntoBalancedIndex(input2)
        val result3 = programmers.bracketvalidation.divideIntoBalancedIndex(input3)
        val result4 = programmers.bracketvalidation.divideIntoBalancedIndex(input4)
        val result5 = programmers.bracketvalidation.divideIntoBalancedIndex(input5)
        val result6 = programmers.bracketvalidation.divideIntoBalancedIndex(input6)
        val result7 = programmers.bracketvalidation.divideIntoBalancedIndex(input7)
        val result8 = programmers.bracketvalidation.divideIntoBalancedIndex(input8)
        var result9 = programmers.bracketvalidation.divideIntoBalancedIndex(input9)

        println("bracket index #1 :: ${result1}")
        println("bracket index #2 :: ${result2}")
        println("bracket index #3 :: ${result3}")
        println("bracket index #4 :: ${result4}")
        println("bracket index #5 :: ${result5}")
        println("bracket index #6 :: ${result6}")
        println("bracket index #7 :: ${result7}")
        println("bracket index #8 :: ${result8}")
        println("bracket index #9 :: ${result9}")
        var u = input9.substring(0, result9+1)
        var v = input9.substring(result9+1, input9.length)
        println("u :: $u, v :: $v")
    }

    @Test
    @DisplayName("올바른 괄호 문자열 테스트")
    fun testCheckIfOk(){
        val input1: String = "()))((()"
        val input2: String = "()))(("
        val input3: String = "()))("
        val input4: String = "()))"
        val input5: String = "())"
        var input6: String = "((()))"
        var input7: String = "((())"
        var input8: String = "(()"
        var input9: String = "()"

        val test1 = programmers.bracketvalidation.checkIfOk(input1)
        println("test #1, ${input1}         :: ${test1}")

        val test2 = programmers.bracketvalidation.checkIfOk(input2)
        println("test #2, ${input2}         :: ${test2}")

        val test3 = programmers.bracketvalidation.checkIfOk(input3)
        println("test #3, ${input3}         :: ${test3}")

        val test4 = programmers.bracketvalidation.checkIfOk(input4)
        println("test #4, ${input4}         :: ${test4}")

        val test5 = programmers.bracketvalidation.checkIfOk(input5)
        println("test #5, ${input5}         :: ${test5}")

        val test6 = programmers.bracketvalidation.checkIfOk(input6)
        println("test #6, ${input6}         :: ${test6}")

        val test7 = programmers.bracketvalidation.checkIfOk(input7)
        println("test #7, ${input7}         :: ${test7}")

        val test8 = programmers.bracketvalidation.checkIfOk(input8)
        println("test #8, ${input8}         :: ${test8}")

        val test9 = programmers.bracketvalidation.checkIfOk(input9)
        println("test #9, $input9         :: $test9")
    }

}