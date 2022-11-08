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

const val RESULT_NUM_LENGTH = 3

fun validateRange() {
    if (RESULT_NUM_LENGTH !in 1..9) throw IllegalArgumentException()
}

fun validateNumInRange(input: String) {
    if(input.length != RESULT_NUM_LENGTH) throw IllegalArgumentException()
}

fun getResultNum(): Int {

    validateRange()
    var resultNum = 0
    val used = BooleanArray(10)
    var len = RESULT_NUM_LENGTH
    while(len>0){
        val num = Randoms.pickNumberInRange(1,9)
        if(used[num]) continue
        resultNum = resultNum*10 + num
        used[num] = true
        len--
    }
    return resultNum
}


fun String.mappingExitCode(): Boolean {
    if (this.isBlank()) throw IllegalArgumentException()
    return when (this[0]) {
        '1' -> false
        '2' -> true
        else -> throw IllegalArgumentException()
    }
}

fun String.mappingInputNumber(): Int {
    return try {
        val ret = this.toInt()
        validateNumInRange(this)
        ret
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }
}

fun matchResult(ballCnt: Int, strikeCnt: Int): Boolean{
    when{
        ballCnt == 0 && strikeCnt == 0 ->{
            println("낫싱")
        }
        strikeCnt == 0 ->{
            println("${ballCnt}볼")
        }
        ballCnt == 0 ->{
            println("${strikeCnt}스트라이크")
        }
        else ->{
            println("${ballCnt}볼 ${strikeCnt}스트라이크")
        }
    }
    return strikeCnt == 3
}

fun matchNumber(input: Int, resultNum: Int): Boolean {

    var tempInput = input
    var tempResultNum = resultNum
    val numCnt = IntArray(10)
    val strikeList = BooleanArray(10)
    while (tempInput > 0) {
        numCnt[tempInput % 10]++
        numCnt[tempResultNum % 10]++
        if (tempInput % 10 == tempResultNum % 10) {
            strikeList[tempInput % 10] = true
        }
        tempInput /= 10
        tempResultNum /= 10
    }
    val ballCnt = numCnt.count { it == 2 && !strikeList[numCnt[it]] }
    val strikeCnt = strikeList.count { it }
    return matchResult(ballCnt, strikeCnt)
}

fun play(resultNum: Int) {
    println("숫자야구 게임을 시작합니다")
    val chance = 3
    for(i in 0 until chance) {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine().mappingInputNumber()
        if (matchNumber(input, resultNum)) {
            println("${RESULT_NUM_LENGTH}개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
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
