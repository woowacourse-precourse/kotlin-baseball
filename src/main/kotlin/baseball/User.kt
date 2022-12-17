package baseball

import camp.nextstep.edu.missionutils.Console

private const val INPUT_LENGTH = 3
private const val INPUT_RANGE_START = '1'
private const val INPUT_RANGE_END = '9'
private const val INPUT_LENGTH_ERROR = "[ERROR] 입력된 숫자가 3자리가 아닙니다."
private const val INPUT_RANGE_ERROR = "[ERROR] 입력이 1에서 9사이가 아닙니다."
private const val INPUT_NUMBER_DUPLICATE = "[ERROR] 중복된 숫자가 입력되었습니다."

class User() {
    private val _userNumbers = mutableListOf<Int>()
    val userNumbers: List<Int> get() = _userNumbers

    fun enterNumbers(inputNumbers: String = Console.readLine()) {
        convertNumberToList(inputNumbers)
    }

    private fun convertNumberToList(inputNumbers: String) {
        checkNumbersLength(inputNumbers)
        _userNumbers.clear()

        inputNumbers.forEach {
            val digit = checkNumberRange(it)
            checkRepeatedNumber(digit)
            _userNumbers.add(digit)
        }
    }

    private fun checkNumbersLength(inputNumbers: String) {
        if (inputNumbers.length != INPUT_LENGTH) throwException(INPUT_LENGTH_ERROR)
    }

    private fun checkNumberRange(c: Char): Int {
        if (c !in INPUT_RANGE_START..INPUT_RANGE_END) throwException(INPUT_RANGE_ERROR)
        return c.toString().toInt()
    }

    private fun checkRepeatedNumber(number: Int) {
        if (_userNumbers.contains(number)) throwException(INPUT_NUMBER_DUPLICATE)
    }

    private fun throwException(exceptionMessage: String) {
        throw IllegalArgumentException(exceptionMessage)
    }
}
