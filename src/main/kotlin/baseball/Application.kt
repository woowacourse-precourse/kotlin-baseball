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
    val numbers = getNumbers()
    while (true) {
        printRequestForInputMessage()
        val userNumbers = getUserNumbers()
        val strikeCount = getStrikeCount(numbers, userNumbers)
        printBallCount(strikeCount)
        if (strikeCount == 3) {
            printGameFinishedMessage()
            break
        }
    }
}

private fun getNumbers(): List<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers
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

private fun getStrikeCount(numbers: List<Int>, userNumbers: List<Int>): Int {
    var strikeCount = 0
    userNumbers.forEach {
        if (numbers.contains(it)) {
            strikeCount++
        }
    }
    return strikeCount
}

private fun printGameFinishedMessage() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

private fun printBallCount(strikeCount: Int) {
    if (strikeCount == 3) {
        println("${strikeCount}스트라이크")
        return
    }
    if (strikeCount in 1..2) {
        println("${3 - strikeCount}볼 ${strikeCount}스트라이크")
        return
    }
    if (strikeCount == 0) {
        println("낫싱")
    }
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