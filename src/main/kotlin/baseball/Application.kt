package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    printWelcomeMessage()

    var intentForNewBaseball = true
    while (intentForNewBaseball) {
        playNewBaseball()
        intentForNewBaseball = getIntentForNewBaseball()
    }
}

private fun printWelcomeMessage() {
    println(Message.WELCOME.message)
}

private fun playNewBaseball() {
    val numbers = getNumbers()
    while (true) {
        printRequestForInputMessage()
        val userNumbers = getUserNumbers()
        val ballCount: List<Int> = getBallCount(numbers, userNumbers)
        printBallCount(ballCount)
        if (ballCount[1] == 3) {
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
    print(Message.REQUEST_FOR_INPUT.message)
}

private fun getUserNumbers(): List<Int> {
    val inputString = Console.readLine()
    return parseInputString(inputString)
}

private fun parseInputString(inputString: String?): List<Int> {
    val numbers = mutableListOf<Int>()
    inputString?.forEach {
        if (it.hasIllegalCharacter()) {
            throw IllegalArgumentException(Message.ILLEGAL_CHARACTER.message)
        }
        val number = it.toNumber()
        if (numbers.contains(number)) {
            throw IllegalArgumentException(Message.ILLEGAL_DUPLICATED_NUMBERS.message)
        }
        numbers.add(number)
    } ?: throw IllegalArgumentException(Message.ILLEGAL_INPUT_NULL.message)

    if (numbers.size != 3) {
        throw IllegalArgumentException(Message.ILLEGAL_SIZE.message)
    }
    return numbers
}

private fun Char.hasIllegalCharacter(): Boolean =
    this.code < '1'.code || this.code > '9'.code

private fun Char.toNumber() = this.code - '0'.code

private fun getBallCount(numbers: List<Int>, userNumbers: List<Int>): List<Int> {
    val ballCount = mutableListOf<Int>(0, 0)
    userNumbers.forEachIndexed { index, userNumber ->
        if (numbers[index] == userNumbers[index]) {
            ballCount[1]++
            return@forEachIndexed
        }
        if (numbers.contains(userNumber)) {
            ballCount[0]++
        }
    }
    return ballCount
}

private fun printGameFinishedMessage() {
    println(Message.GAME_FINISHED.message)
}

private fun printBallCount(ballCount: List<Int>) {
    val ball = ballCount[0]
    val strike = ballCount[1]
    if (ball != 0 && strike != 0) {
        println("${ball}볼 ${strike}스트라이크")
        return
    }
    if (ball != 0) {
        println("${ball}볼")
        return
    }
    if (strike != 0) {
        println("${strike}스트라이크")
        return
    }
    if (ball == 0 && strike == 0) {
        println("낫싱")
        return
    }
}

private fun getIntentForNewBaseball(): Boolean {
    printNewGameMessage()
    val input = Console.readLine()
    if (input == "1") {
        return true
    }
    if (input == "2") {
        return false
    }
    throw IllegalArgumentException(Message.ILLEGAL_INTENT.message)
}

private fun printNewGameMessage() {
    println(Message.NEW_GAME.message)
}

enum class Message(val message: String) {
    WELCOME("숫자 야구 게임을 시작합니다."),
    REQUEST_FOR_INPUT("숫자를 입력해주세요 : "),
    ILLEGAL_CHARACTER("Character in InputString is out of range"),
    ILLEGAL_DUPLICATED_NUMBERS("Duplicated numbers"),
    ILLEGAL_INPUT_NULL("InputString is null"),
    ILLEGAL_SIZE("Numbers.size not 3"),
    ILLEGAL_INTENT("Intent can be only 1 or 2"),
    GAME_FINISHED("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NEW_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
}