package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computer: String = ""
    var gameStatus: Int = 0 // 0: 게임 시작전, 1: 게임 시작(중), 2: 게임 종료

    while (gameStatus != 2) {
        if (gameStatus == 0) {
            computer = randomNum()
            gameStatus = 1
        }
        print("숫자를 입력해주세요 : ")
        val userInput = readLine()!!
        println(userInput)
        userWrongTypeAnswer(userInput)
        userWrongSizeAnswer(userInput)
        userWrongDuplicationAnswer(userInput)
        println(userAnswerCount(computer, userInput))
        if (userCorrectAnswer(computer, userInput)) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            gameStatus = if (!gameRestart()) 2 else 0
        }
    }
}

fun randomNum(): String {
    var computer: String = ""
    while (computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber.toString())) {
            computer += randomNumber
        }
    }
    return computer
}

fun userWrongTypeAnswer(userAnswer: String) {
    try {
        Integer.parseInt(userAnswer)
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("게임 종료")
    }
}

fun userWrongSizeAnswer(userAnswer: String) {
    if (userAnswer.length != 3) throw IllegalArgumentException("게임 종료")
}

fun userWrongDuplicationAnswer(userAnswer: String) {
    userAnswer.forEach { it ->
        if (userAnswer.count { c -> c == it } > 1) throw IllegalArgumentException("게임 종료")
    }
}

fun userAnswerCount(answer: String, userAnswer: String): String {
    val score = mutableListOf<Int>(0, 0, 0) // 스트라이크/볼/아웃

    answer.forEachIndexed { index, c ->
        if (c == userAnswer[index]) score[0] += 1
        else if (userAnswer.contains(c)) score[1] += 1
        else score[2] += 1
    }
    return userAnswerCountPrint(score)
}

fun userAnswerCountPrint(score: MutableList<Int>): String {
    var userAnswerCountString = ""
    if (score[1] != 0) userAnswerCountString += "${score[1]}볼"
    if (score[0] != 0) {
        if (userAnswerCountString.isNotEmpty()) userAnswerCountString += " "
        userAnswerCountString += "${score[0]}스트라이크"
    }
    if (score[2] == 3) userAnswerCountString += "낫싱"

    return userAnswerCountString
}

fun userCorrectAnswer(answer: String, userAnswer: String): Boolean {
    return answer == userAnswer
}

fun gameRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (val userChoice = readLine()) {
        "1" -> {
            println(userChoice)
            true
        }

        "2" -> {
            println("게임종료")
            false
        }

        else -> throw IllegalArgumentException("게임 종료")

    }
}