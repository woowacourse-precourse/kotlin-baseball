package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(RANDOM_LOWER_NUMBER,RANDOM_UPPER_NUMBER)
    }

    companion object{
        const val RANDOM_LOWER_NUMBER = 1
        const val RANDOM_UPPER_NUMBER = 9
    }
}