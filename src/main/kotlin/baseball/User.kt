package baseball

import camp.nextstep.edu.missionutils.Console

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
        if (inputNumbers.length != 3) throwException("입력된 숫자가 3자리가 아닙니다.")
    }

    private fun checkNumberRange(c: Char): Int {
        if (c !in '1'..'9') throwException("입력이 1에서 9사이가 아닙니다.")
        return c.toString().toInt()
    }

    private fun checkRepeatedNumber(number: Int) {
        if (_userNumbers.contains(number)) throwException("중복된 숫자가 입력되었습니다.")
    }

    private fun throwException(exceptionMessage: String) {
        throw IllegalArgumentException(exceptionMessage)
    }
}
