package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var playGame = 1
    while (playGame == 1) {
        play()
        playGame = Console.readLine().checkExceptionInRestarting().toInt()
    }
}

fun play() {
    val answerList: List<String> = setGame()
    while (true) {
        print("숫자를 입력해주세요 : ")
        val compareResult = answerList.compareAnswer(Console.readLine().checkExceptionInGaming())
        if (compareResult.second == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        } else if (compareResult.first == 0 && compareResult.second == 0) println("낫싱")
        else println("${compareResult.first}볼 ${compareResult.second}스트라이크")
    }
}

fun setGame(): List<String> {
    val answerList: MutableList<String> = mutableListOf()
    while (answerList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answerList.contains(randomNumber.toString())) answerList.add(randomNumber.toString())
    }
    return answerList
}

fun List<String>.compareAnswer(string: String): Pair<Int, Int> {
    var ball = 0
    var strike = 0
    string.forEachIndexed { index, c ->
        if (this[index] == c.toString()) strike++
        else if (this.contains(c.toString())) ball++
    }
    return Pair(ball, strike)
}

fun String.checkExceptionInGaming(): String {
    if (this.length != 3) throw IllegalArgumentException()
    this.forEach {
        if (it !in '1'..'9') throw IllegalArgumentException()
    }
    return this
}

fun String.checkExceptionInRestarting(): String {
    if (this != "1" && this != "2") throw IllegalArgumentException()
    return this
}