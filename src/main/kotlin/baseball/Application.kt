package baseball

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

fun main() {
    TODO("프로그램 구현")
}
