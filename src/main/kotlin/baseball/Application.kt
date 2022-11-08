package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

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
