package baseball.domain

import baseball.resources.*

class Player {
    private var _number = String()
    val number: String get() = _number

    fun saveIfValid(number: String) {
        require(number.all { Character.isDigit(it) }) {
            INPUT_VALUE_WITH_MIXED_CHARACTERS
        }
        require(number.length == RULE_NUMBER_SIZE) {
            INPUT_VALUE_NOT_THREE_DIGITS
        }
        require(number.toSet().size == RULE_NUMBER_SIZE) {
            INPUT_VALUE_DUPLICATES
        }
        require(number.all { it.digitToInt() != ZERO }) {
            INPUT_VALUE_IF_CONTAINS_ZERO
        }

        save(number)
    }

    private fun save(number: String) {
        this._number = number
    }
}
