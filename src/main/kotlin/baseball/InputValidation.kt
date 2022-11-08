package baseball

class InputValidation (val inputNumber: String) {
    companion object {
        const val NUMBER_LENGTH = 3
    }

    fun inputNumberExceptionCheck(): Boolean {
        inputNumber.map { it.digitToInt() }.toList()
        if (!(lengthCheck() && overlapCheck() && rangeCheck())) {
            throw IllegalArgumentException()
        }
        return true
    }

    fun lengthCheck(): Boolean {
        return inputNumber.length == NUMBER_LENGTH
    }

    fun overlapCheck(): Boolean {
        val myset: Set<Char> = HashSet(inputNumber.toList())
        return myset.size == NUMBER_LENGTH
    }

    fun rangeCheck(): Boolean {
        return !inputNumber.contains("0")
    }

    fun restartNumberExceptionCheck(): Boolean {
        val validNumber: List<Int> = listOf(1, 2)
        if (!validNumber.contains(inputNumber.toInt())) {
            throw IllegalArgumentException()
        }
        return true
    }
}
