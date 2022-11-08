package baseball

import camp.nextstep.edu.missionutils.Randoms

object Computer {

    var randomNumber: String = ""
        private set

    fun generateRandomNumber() {
        val randomNumbersSet = mutableSetOf<Int>()

        while (randomNumbersSet.size != 3) {
            randomNumbersSet.add(
                Randoms.pickNumberInRange(1, 9)
            )
        }
        randomNumber = randomNumbersSet.joinToString("")
    }
}