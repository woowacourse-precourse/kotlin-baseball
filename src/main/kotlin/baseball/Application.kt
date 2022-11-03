package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGame()
}

fun printStartGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun printEnterNumber() {
    print("숫자를 입력해주세요 : ")
}

fun throwThreeLetterException(input: List<Char>) {
    val numberOfDigits = 3
    if (input.size != numberOfDigits) {
        throw IllegalArgumentException("3개의 숫자를 입력하세요")
    }
}

fun throwNonNumberException(input: List<Char>) {
    val asciiCodeZero = 48
    val asciiCodeNine = 57
    input.forEach { char ->
        if (char.code < asciiCodeZero || char.code > asciiCodeNine) {
            throw IllegalArgumentException("숫자만 입력하세요")
        }
    }
}

fun throwDuplicateNumberException(input: List<Char>) {
    if (input.distinct() != input) {
        throw IllegalArgumentException("서로 다른수를 입력해주세요")
    }
}

fun checkAllException(input: List<Char>) {
    throwThreeLetterException(input)
    throwNonNumberException(input)
    throwDuplicateNumberException(input)
}

fun getInputListFromKeyboard() = Console.readLine().toList()

fun convertCharacterListToIntList(input: List<Char>): List<Int> {
    return input.map { char ->
        char.digitToInt()
    }
}

