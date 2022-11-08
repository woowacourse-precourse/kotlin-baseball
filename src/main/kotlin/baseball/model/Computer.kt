package baseball.model

import baseball.utils.Constant.CNT_NUMBER
import baseball.utils.Constant.DEFAULT_STRING
import baseball.utils.Constant.MAX_NUMBER
import baseball.utils.Constant.MIN_NUMBER
import camp.nextstep.edu.missionutils.Randoms

object Computer {

    var randomNumber: String = DEFAULT_STRING
        private set

    fun generateRandomNumber() {
        val randomNumbersSet = mutableSetOf<Int>()

        while (randomNumbersSet.size != CNT_NUMBER) {
            randomNumbersSet.add(
                Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            )
        }
        randomNumber = randomNumbersSet.joinToString("")
    }
}