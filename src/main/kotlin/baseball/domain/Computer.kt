package baseball.domain

import baseball.resources.*
import baseball.util.interfaces.RandomUtil

class Computer(private val randomUtil: RandomUtil) {
    private var _number: String = NULL
    val number: String get() = _number

    fun makeRandomNumbers() {
        _number = NULL
        val newNumber = mutableSetOf<String>()

        while (newNumber.size < RULE_NUMBER_SIZE) {
            newNumber.add(randomUtil.generate())
        }

        newNumber.forEach { _number = _number.plus(it) }
    }
}
