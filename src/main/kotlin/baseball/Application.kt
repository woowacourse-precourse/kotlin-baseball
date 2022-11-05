package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startGame()
}

fun readNum(): MutableList<String> { // 사용자가 숫자를 입력받는 함수
        print("숫자를 입력하세요 : ")
        val number = readLine()!!
        val numberArray = number.split("") as MutableList<String>
        val newArray = mutableListOf<String>()
        numberArray.removeAt(0)
        numberArray.removeAt(numberArray.size - 1)

        if (number.length != 3) {
            throw IllegalArgumentException()
        }

        for (i in 0..2) {
            if (newArray.contains(numberArray[i])) {
                throw IllegalArgumentException()
            }
            newArray.add(numberArray[i])
        }
    return newArray
}

fun computerNum(): MutableList<String> { // 컴퓨터가 랜덤으로 숫자를 정하는 함수
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
    // 스트라이크, 볼의 개수를 세고 출력해주는 함수
    var ball = 0
    var strike = 0

    for (i in 0..2) {
        if (playerList[i] == computerList[i]) {
            strike++
        }
        else if ((playerList[i] == computerList[0] || playerList[i] == computerList[1] || playerList[i] == computerList[2]) && playerList[i] != computerList[i]) {
            //contains 사용해봤는데 ball이 안들어감. 일단 이렇게 구현부터 해놓고 리팩토링때 다시 해보기
            //playerList[i].contains(computerList[i])
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
        println("${strike}스트라이크 ${ball}볼")
    }
    else if (strike == 3 && ball == 0) {
        println("${strike}스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        reStartExit()
    }
    else println("낫싱")
}

fun reStartExit() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
    val reStart = readLine()!!.toInt()
    when (reStart) {
        1 -> {
            startGame()
        }
        2 -> {
            exitProcess(0)
        }
        else -> throw IllegalArgumentException()
    }
}

fun startGame() {
    val computerNumList = computerNum()
    for (i in 0..100) {
        //배열이 서로 같아질때 까지 반복해야되는데, 안되서 이걸로 대체함
        ballCount(readNum(), computerNumList)
    }
}