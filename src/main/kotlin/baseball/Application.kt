package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printWelcomeMessage()

    var intentForNewBaseball = true
    while (intentForNewBaseball) {
        playNewBaseball()
        intentForNewBaseball = getIntentForNewBaseball()
    }
}

private fun printWelcomeMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

private fun playNewBaseball() {
    while (true) {
        TODO()
        printRequestForInputMessage()
        val userNumbers = getUserNumbers()
        if (getBallCount() == 3) {
            printGameFinishedMessage()
            break
        }
    }
}

private fun printRequestForInputMessage() {
    print("숫자를 입력해주세요 : ")
}

private fun getUserNumbers(): List<Int> {
    val inputString = readLine()
    return parseInputString(inputString)
}

private fun parseInputString(inputString: String?): List<Int> {
    val numbers = mutableListOf<Int>()
    inputString?.forEach {
        if (hasIllegalCharacter(it)) {
            throw IllegalArgumentException("Character in InputString is out of range")
        }
        val number = it.toNumber()
        if (numbers.contains(number)) {
            throw IllegalArgumentException("Duplicated numbers")
        }
        numbers.add(number)
    } ?: throw IllegalArgumentException("InputString is null")

    if (numbers.size != 3) {
        throw IllegalArgumentException("Numbers.size not 3")
    }
    return numbers
}

private fun hasIllegalCharacter(char: Char): Boolean =
    char.code < '1'.code || char.code > '9'.code

private fun Char.toNumber() = this.code - '0'.code

private fun getBallCount(): Int {
    TODO()
}

private fun printGameFinishedMessage() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

private fun getIntentForNewBaseball(): Boolean {
    printNewGameMessage()
    val input = readLine()
    if (input == "1") {
        return true
    }
    if (input == "2") {
        return false
    }
    return getIntentForNewBaseball()
}

private fun printNewGameMessage() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}