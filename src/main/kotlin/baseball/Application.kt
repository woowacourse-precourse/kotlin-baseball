package baseball

import camp.nextstep.edu.missionutils.Randoms

const val SIZE_LIMIT = 3
const val MIN_VALUE = 1
const val MAX_VALUE = 9
const val RESTART = 1
const val FINISH = 2

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playGame()
}

fun playGame() {
    val answer = getComputerNumber()
    //println(answer)
    startGuessing(answer)
}

// 컴퓨터의 랜덤 숫자 생성
fun getComputerNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < SIZE_LIMIT) {
        val randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

// 정답을 맞힐 때까지 반복해서 힌트 출력
fun startGuessing(answer: String) {
    var input = getUserNumber()
    while(input != answer){
        println(getHint(input, answer))
        input = getUserNumber()
    }
    gameOver()
}

// 사용자로부터 서로 다른 3자리 수 입력 받기
fun getUserNumber(): String {
    print("숫자를 입력해주세요: ")
    val input = readLine()!!

    // 3자리 수가 아닌 경우
    if (input.length != SIZE_LIMIT)
        throw IllegalArgumentException()

    // 1~9까지의 범위를 벗어난 경우 (문자 포함)
    for (item in input) {
        if (item.digitToInt() !in MIN_VALUE..MAX_VALUE)
            throw IllegalArgumentException()
    }

    // 중복된 숫자가 있는 경우
    val list = input.toList()
    if(list.toSet().size != list.size)
        throw IllegalArgumentException()

    return input
}

// 스트라이크, 볼, 낫싱 결과 출력
fun getHint(input: String, answer: String): String {
    var strike = 0
    var ball = 0
    for(i in answer.indices){
        if(input[i] == answer[i]) strike++
        else if(input.contains(answer[i])) ball++
    }

    val hint = if (strike != 0 && ball != 0) {
        "${ball}볼 ${strike}스트라이크"
    } else {
        if (strike != 0) "${strike}스트라이크"
        else if (ball != 0) "${ball}볼"
        else "낫싱"
    }

    return hint
}

// 정답을 맞힌 경우, 게임 재시작 or 종료
fun gameOver() {
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when(readLine()!!.toInt()) {
        RESTART -> playGame()
        FINISH -> return
        else -> throw IllegalArgumentException()
    }
}
