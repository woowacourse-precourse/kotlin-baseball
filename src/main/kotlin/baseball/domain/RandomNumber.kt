package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

data class RandomNumber(var number: Int = DEFAULT_NUMBER) {

    init {
        number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }

    fun value(): Int = number

    companion object {
        const val DEFAULT_NUMBER = -1
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 9
    }
}