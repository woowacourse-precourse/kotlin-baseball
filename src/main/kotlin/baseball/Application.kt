package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playBaseballGame()
}


fun endOrReplay() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = readLine()

    if (input == "1") {
        println(1)
        playBaseballGame()
    }
    else if (input == "2") {
        println(2)
        println("숫자 야구 게임을 종료합니다.")
    }
}

fun playBaseballGame() {
    val randomNumber = setRandomNumber()

    do {
        val userNumber = getUserNumber()
        val score = countBaseballScore(randomNumber, userNumber)
    }
    while (!score)

    endOrReplay()
}


fun countBaseballScore(randomNumber: List<String>, userNumber: String): Boolean {
    var ball = 0
    var strike = 0

    userNumber.forEach {
        if (randomNumber.contains(it.toString())) ball += 1
    }

    for (i in 0 until 3) {
        if (randomNumber[i] == userNumber[i].toString()) strike += 1
    }

    ball -= strike

    when {
        ball == 0 && strike == 0 -> {
            println("낫싱")
        }
        strike == 3 -> {
            println("${strike}스트라이크")
            return true
        }

        ball > 0 || strike > 0 -> {
            println("${ball}볼 ${strike}스트라이크")
        }
    }

    return false
}


fun getUserNumber(): String {
    print("숫자를 입력해주세요 : ")
    val userNumber = readLine()
    println(userNumber)

    if(isInvalidNumber(userNumber)) {
        throw IllegalArgumentException()
    }

    return userNumber
}


fun setRandomNumber(): List<String> {
    val baseballNumber = mutableListOf<String>()

    while (baseballNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()

        if (!baseballNumber.contains(randomNumber)) {
            baseballNumber.add(randomNumber)
        }
    }

    return baseballNumber
}


fun isInvalidNumber(userNumber : String) : Boolean{
    val regex = Regex("^[0-9]{3}\$")

    return !regex.matches(userNumber)
}