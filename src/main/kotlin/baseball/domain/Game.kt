package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class Game(var strike: Int = 0, var ball: Int = 0) {

    val computerNumber = mutableListOf<Int>()

    init {
        generateComputerNumber()
    }

    private fun generateComputerNumber() {
        while (computerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
    }

    fun compare(userNumber: List<Int>) {
        userNumber.onEachIndexed { index, number ->
            if (number == computerNumber[index]) {
                strike += 1
            } else if (computerNumber.contains(number)) {
                ball += 1
            }
        }
    }

    fun resetScore() {
        strike = 0
        ball = 0
    }
}
