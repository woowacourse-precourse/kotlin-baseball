package baseball

import camp.nextstep.edu.missionutils.Randoms

/* 기능 목록
* 입력 예외 처리
*   resultNum 입력
* 게임 구현
* 종료 및 재시작 구현
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

fun main() {
    val resultNum = getResultNum()
}
