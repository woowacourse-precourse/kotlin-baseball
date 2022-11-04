package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private lateinit var _number: String
    val number: String get() = _number

    init {
        makeRandomNumbers()
    }

    private fun makeRandomNumbers() {
        do {
            this._number = Randoms.pickNumberInRange(111, 999).toString()
        } while (validateNumbers(_number))
    }

    private fun validateNumbers(_number: String): Boolean {
        return validateIfContainsZero(_number) || validateIfContainsDuplicates(_number)
    }

    fun validateIfContainsDuplicates(_number: String): Boolean {
        return _number.toSet().size != 3
    }
    fun validateIfContainsZero(_number: String): Boolean {
        return _number.any { it == '0' }
    }
}
