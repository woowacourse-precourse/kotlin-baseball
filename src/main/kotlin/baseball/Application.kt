package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startGame()
}

fun readNum(): MutableList<String> {
        print("숫자를 입력하세요 : ")
        val number = readLine()!!
        val numberArray = number.split("") as MutableList<String>
        val newArray = mutableListOf<String>()
        numberArray.removeAt(0)
        numberArray.removeAt(numberArray.size - 1)

        val notZeroArray = mutableListOf("0")
        if (numberArray.contains(notZeroArray[0])) {
            throw IllegalArgumentException("0이 아닌 수만 입력이 가능합니다.")
        }

        if (number.length != 3) {
            throw IllegalArgumentException("3자리 숫자만 입력해주세요")
        }

        for (i in 0..2) {
            if (newArray.contains(numberArray[i])) {
                throw IllegalArgumentException("숫자가 겹치거나 연속되는 숫자입니다.")
            }
            newArray.add(numberArray[i])
        }
    return newArray
}

fun computerNum(): MutableList<String> {
    val computer = mutableListOf<String>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun ballCount(playerList: MutableList<String>, computerList: MutableList<String>) {
    var ball = 0
    var strike = 0

    for (i in 0..2) {
        if (playerList[i] == computerList[i]) {
            strike++
        }
        else if ((playerList[i] == computerList[0] || playerList[i] == computerList[1] || playerList[i] == computerList[2]) && playerList[i] != computerList[i]
                ) {
            ball++
        }
    }

    if (ball in 1..3 && strike == 0) {
        println("${ball}볼")
    }
    else if (strike in 1..2 && ball == 0) {
        println("${strike}스트라이크")

    }
    else if (ball in 1..3 && strike in 1..2) {
        println("${ball}볼 ${strike}스트라이크 ")
    }
    else if (strike == 3 && ball == 0) {
        println("${strike}스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        reStartOrExit()
    }
    else println("낫싱")
}

fun reStartOrExit() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
    val reStart = readLine()!!.toInt()
    when (reStart) {
        1 -> {
            startGame()
        }
        2 -> {
            println("게임을 종료합니다..")
            exitProcess(0)
        }
        else -> throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }
}

fun startGame() {
    val computerNumList = computerNum()
    for (i in 0..100) {
        ballCount(readNum(), computerNumList)
    }
}