package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

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

    if ( (input.toInt() < 1) || (input.toInt() > 9) ){
        throw IllegalArgumentException()
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
