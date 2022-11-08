package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException


fun main() {
    playGameStart()
    checkRestartOrEnd()
}

fun playGameStart() {
    setGameStartMessage()
    getUserInput()
    printResultMessage()
}


fun setRandomAnswer(): ArrayList<Int> {
    var answer = arrayListOf<Int>()

    while (answer.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNum))
            answer += randomNum
    }
    return answer
}

fun setGameStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserInput(): MutableList<Int> {
    println("숫자를 입력해주세요 :")
    return camp.nextstep.edu.missionutils.Console.readLine().map { it.digitToInt() }.toMutableList()
}

fun checkStrike(answer: ArrayList<Int>, user: MutableList<Int>) {
    var strikeCountNum = 0
    for (i in 0 until answer.size)
        if (answer[i] == user[i])
            strikeCountNum += 1

    if (strikeCountNum > 0)
        println("${strikeCountNum}스트라이크")
}

fun checkBall(answer: ArrayList<Int>, user: MutableList<Int>) {
    var ballCountNum = 0
    for (i in 0 until answer.size)
        if (answer[i] != user[i] && user.contains(answer[i]))
            ballCountNum += 1
    if (ballCountNum > 0)
        println("${ballCountNum}볼")
}

fun checkNothing(answer: ArrayList<Int>, user: MutableList<Int>) {
    for (i in 0 until answer.size)
        if (!user.contains(answer[i]))
            println("낫싱")
}

fun printResultMessage() {
    val answer = setRandomAnswer()
    val user = getUserInput()

    checkBall(answer, user)
    checkStrike(answer, user)
    checkNothing(answer, user)
}

fun checkRestartOrEnd() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")
    when (camp.nextstep.edu.missionutils.Console.readLine()) {
        "1" ->
            playGameStart()
        "2" -> return

        else -> throw IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}







