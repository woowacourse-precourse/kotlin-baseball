package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun createOpponentData(): String {
    var opponentData = ""

    while(opponentData.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!opponentData.contains(randomNumber.toString()))
            opponentData += randomNumber.toString()
    }

    return opponentData
}

fun isNegativeNumber(inputData: String): Boolean {
    return inputData.toInt() < 0
}

fun isNotThreeDigits(inputData: String): Boolean {
    return inputData.length != 3
}

fun isNotInteger(inputData: String): Boolean {
    try{
        inputData.toInt()
    }catch (e: NumberFormatException) {
        return true
    }
    return false
}

fun isGameOver(inputResult: List<Int>): Boolean {
    val strikeCount = inputResult[1]

    return strikeCount == 3
}

fun continueGame(inputContinue: String): Boolean {
    return inputContinue.toInt() == 1
}

fun compareData(opponentData: String, inputData: String):List<Int> {
    var ballCount = 0
    var strikeCount = 0

    for(index in opponentData.indices) {
        if(opponentData[index] == inputData[index]) strikeCount++
        else if(opponentData.contains(inputData[index])) ballCount++
    }

    return listOf(ballCount, strikeCount)
}

fun gameResultString(inputResult: List<Int>): String {
    val ballCount = inputResult[0]
    val strikeCount = inputResult[1]

    var printString = ""

    if(ballCount == 0 && strikeCount == 0)
        printString = "낫싱"

    if(ballCount > 0) {
        printString = "${ballCount}볼"

        if(strikeCount > 0)
            printString += " ${strikeCount}스트라이크"

        return printString
    }

    if(strikeCount > 0) {
        printString = "${strikeCount}스트라이크"

        if(strikeCount == 3)
            printString += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }

    return printString
}

fun main() {
    var opponentData = createOpponentData()

    println("숫자 야구 게임을 시작합니다.")
    var isRunning = true
    while(isRunning) {
        print("숫자를 입력해주세요. : ")

        val inputData = Console.readLine()

        if(isNotInteger(inputData))
            throw IllegalArgumentException()

        if(isNotThreeDigits(inputData))
            throw IllegalArgumentException()

        if(isNegativeNumber(inputData))
            throw IllegalArgumentException()

        val inputResult = compareData(opponentData, inputData)

        println(gameResultString(inputResult))
        if(isGameOver(inputResult)) {
            val inputContinue = Console.readLine()

            if(!continueGame(inputContinue)) {
                isRunning = false
            }
            else {
                opponentData = createOpponentData()
            }
        }
    }
}
