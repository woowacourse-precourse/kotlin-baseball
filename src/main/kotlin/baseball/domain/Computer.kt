package baseball.domain

import baseball.resources.*
import baseball.util.RandomGenerate

class Computer {
    private var _number: String = NULL
    val number: String get() = _number
    private val randomGenerate = RandomGenerate()

    fun makeRandomNumbers() {
        _number = NULL
        val set = mutableSetOf<String>()

        while (set.size < 3) {
            set.add(randomGenerate.generate())
        }
        set.forEach { _number = number.plus(it) }
    }
}
