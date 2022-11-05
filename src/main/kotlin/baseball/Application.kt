package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = createComputerNumber()
    startGame(computerNumber)
}

fun startGame(computerNumber: ArrayList<Int>) {
    var SUCCESS = false
    while (!SUCCESS) {
        print("숫자를 입력해주세요 : ")
        var userInput = readLine()?.toMutableList()
        val strikeAndBall = checkNumber(computerNumber,userInput)

        if (strikeAndBall[0] == 3) {
            println("${strikeAndBall[0]}스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            SUCCESS = true
        }
        else if (strikeAndBall[0] != 0 && strikeAndBall[1] != 0) {
            println("${strikeAndBall[1]}볼 " + "${strikeAndBall[0]}스트라이크")
        }
        else if (strikeAndBall[0]!=0) {
            println("${strikeAndBall[0]}스트라이크")
        }
        else if (strikeAndBall[1]!=0) {
            println("${strikeAndBall[1]}볼")
        }
        else {
            println("낫싱")
        }
    }
}

fun checkNumber(computerNumber: ArrayList<Int>, userInput: MutableList<Char>?): Array<Int> {
    // strikeAndBall[0] -> 스트라이크, strikeAndBall[1] -> 볼
    var strikeAndBall = Array<Int>(2) {0}

    for (i in 0 until 3) {
        if (computerNumber[i] == userInput!![i].digitToInt()) {
            strikeAndBall[0]++
        }
        else if (computerNumber.contains(userInput!![i].digitToInt())) {
            strikeAndBall[1]++
        }
    }

    return strikeAndBall
}

fun createComputerNumber(): ArrayList<Int> {
    val computerNumber = ArrayList<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    println("숫자 야구 게임을 시작합니다.$computerNumber")
    return computerNumber
}