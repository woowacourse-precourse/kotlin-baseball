package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val RESTART = 1
const val EXIT = 2
fun main() {

    val computer = computerNumber()

    gameStart()
    gamePlay(computer)

}

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun gameOver() {

    val result = Console.readLine().toInt()

    println("result : $result")
    when (result) {
        EXIT -> {
            println("게임 종료")
        }

        RESTART -> {
            val computerNewInput = computerNumber()

            gameStart()
            gamePlay(computerNewInput)
        }

        else -> {
            throw IllegalArgumentException("${RESTART}나 ${EXIT}를 입력해야 합니다.")
        }
    }

}
fun gamePlay(computer: MutableList<Int>) {

    while (true) {

        val user = userInputNumber()
        println("숫자를 입력해주세요 : $user")

        if (gameResult(user, computer) == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            gameOver()
            break
        }
    }

}

fun gameResult(userInput: MutableList<Int>, computerInput: MutableList<Int>): Int {

    var strikeCount = 0
    var ballCount = 0

    for (i in 0..2) {
        if (computerInput[i] == userInput[i]) {
            strikeCount++
        } else if (computerInput.contains(userInput[i])) {
            ballCount++
        }
    }

    if ((strikeCount != 0) && (ballCount != 0)) {
        println("${ballCount}볼 ${strikeCount}스트라이크")
    } else if (strikeCount != 0) {
        println("${strikeCount}스트라이크")
    } else if (ballCount != 0) {
        println("${ballCount}볼")
    } else {
        println("낫싱")
    }

    return strikeCount
}

fun inputErrorCheck(input: String) {

    if (input.length != 3) {
        println(input.length)
        throw IllegalArgumentException()
    }

}

fun inputRangeCheck(inputList: List<Int>){

    for (i in 0..2){
        if (inputList[i] < 1 || inputList[i] > 9){
            throw IllegalArgumentException()
        }
    }
}
fun duplicateCheck(inputList: List<Int>): Boolean {
    return inputList.size != inputList.distinct().count()
}

fun userInputNumber(): MutableList<Int> {

    val userInputList = MutableList(3) { 0 }
    val userInputNumber = Console.readLine()

    inputErrorCheck(userInputNumber)
    for (i in 0..2) {
        userInputList[i] = userInputNumber[i].digitToInt()
    }

    if (duplicateCheck(userInputList)) {
        throw IllegalArgumentException()
    }
    inputRangeCheck(userInputList)

    return userInputList
}

fun computerNumber(): MutableList<Int> {
    // 1부터 9까지의 랜덤한 3가지 수 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    // println("computer Input 값 : $computer")
    return computer
}
