package baseball.domain

import baseball.resources.*
import baseball.util.RandomGenerate

class Computer {
    private var _number: String = NULL
    val number: String get() = _number
    private val randomGenerate = RandomGenerate()

    fun makeRandomNumbers() {
        _number = NULL
        val newNumber = mutableSetOf<String>()

        while (newNumber.size < RULE_NUMBER_SIZE) {
            newNumber.add(randomGenerate.generate())
        }

        newNumber.forEach { _number = _number.plus(it) }
    }
}
