package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/* 기능 목록
* 입력 예외 처리
*   resultNum 입력
*   inputNum, exitCode 입력
* 종료 및 재시작 구현 (게임 틀)
* 게임 내용 구현
* */

const val RESULT_NUM_RANGE = 3

fun validateRange() {
    if (RESULT_NUM_RANGE !in 1..9) throw IllegalArgumentException()
}

fun getResultNum(): Int {

    validateRange()

    val (start, end) = getResultRange()
    val resultNum = Randoms.pickNumberInRange(start, end)

    validateNumInRange(resultNum)

    return resultNum
}

fun getResultRange(): Pair<Int, Int> {
    var start = 0
    var end = 0
    repeat(RESULT_NUM_RANGE) {
        start = start * 10 + 1
        end = end * 10 + 9
    }
    return Pair(start, end)
}

fun validateNumInRange(num: Int) {
    val (start, end) = getResultRange()
    if (num !in start..end) throw IllegalArgumentException()
}

fun String.mappingExitCode(): Boolean {
    if(this.isBlank()) throw IllegalArgumentException()
    return when (this[0]) {
        '1' -> false
        '2' -> true
        else -> throw IllegalArgumentException()
    }
}

fun String.mappingInputNumber(): Int{
    return try{
        val ret = this.toInt()
        validateNumInRange(ret)
        ret
    }catch (e: Exception){
        throw IllegalArgumentException()
    }
}

fun play(resultNum: Int){
    println("숫자야구 게임을 시작합니다")
    val chance = 3
    repeat(chance) {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine().mappingInputNumber()
        println("ok")
    }
    println("게임 종료")
}

fun main() {
    var exit = false
    while (!exit) {
        val resultNum = getResultNum()
        play(resultNum)
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        exit = Console.readLine().mappingExitCode()
    }
}
