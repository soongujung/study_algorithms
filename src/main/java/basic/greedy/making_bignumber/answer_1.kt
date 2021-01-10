package basic.greedy.making_bignumber

import java.util.*

fun main(args: Array<String>) : Unit {
    val read = Scanner(System.`in`)
    val narration : String = "(숫자 입력후 Enter키 입력)"

    println("배열의 크기(N)를 입력해주세요 :: $narration")
    val len = read.nextInt()

//    println("")
    println("숫자를 더할 횟수(M)를 입력해주세요 :: $narration")
    val cntAdd = read.nextInt()

//    println("")
    println("연속 덧셈 가능한 횟수(K)를 입력해주세요 :: $narration")
    val cntContinuous = read.nextInt()

//    println("")
    println("숫자의 배열을 입력하세요 :: (공백으로 구분, Enter키 입력하여 배열 생성 종료)")
    val mutableListOf = mutableListOf<Int>()

    for(i in 0 until len){
        val temp = read.nextInt()
        mutableListOf.add(temp)
    }

    println("입력하신 데이터 = ${mutableListOf.toString()}")
    val result = answer(array = mutableListOf.toTypedArray(), size = len, cntAdd = cntAdd, cntContinuous = cntContinuous)
    println("연산결과입니다 :: $result")
}

data class Element (
    var value : Int,
    var index : Int
)

fun answer (array: Array<Int>, size: Int, cntAdd: Int, cntContinuous: Int) : Int {
    val firstMaxElement : Element = Element(value = 0, index = 0)
    val secondMaxElement : Element = Element(value = 0, index = 0)

    // 정렬을 해서 가장 뒤의 요소, 뒤에서 두번째 요소를 얻어내서 해도 된다.
    // nlogn 알러지가 있어서 ㅋㅋ ... O(n) 수행시간을 두번 돌려서 큰 수를 추려냈다.
    // 이렇게 하면 시간복잡도가 상수시간 타임이므로 그리 큰 문제는 안되긴 한다.

    for(i in 0 until array.size){
        var v = array[i]
        if(firstMaxElement.value < v) {
            firstMaxElement.index = i
            firstMaxElement.value = v
        }
    }

    for(i in 0 until array.size){
        var v = array[i]
        if(secondMaxElement.value < v && i != firstMaxElement.index){
            secondMaxElement.index = i
            secondMaxElement.value = v
        }
    }

//    println("firstMax = $firstMax , secondMax = $secondMax")
    println("")
    println("firstMaxElement :: ${firstMaxElement.toString()}")
    println("secondMaxElement :: ${secondMaxElement.toString()}")

    // 순열(순서가 정해진 숫자들의 나열)이 반복될 횟수
    val cntSeries = cntAdd/(cntContinuous + 1)

    // unitSumSeries 단위 순열의 SUM
    var unitSumSeries = (cntContinuous * firstMaxElement.value) + secondMaxElement.value

    val sumSeries = cntSeries * unitSumSeries

    // 나머지 (firstMaxElement를 cntModSeries 만큼 반복해서 더한다. 단, cntModSeries 가 0이 아닐때에만 해당된다.)
    val cntModSeries = cntAdd%(cntContinuous + 1)
    var sumModSeries = 0

    if(cntModSeries <= 0)
        sumModSeries = 0
    else
        sumModSeries = cntModSeries * firstMaxElement.value

    return sumSeries + sumModSeries
}