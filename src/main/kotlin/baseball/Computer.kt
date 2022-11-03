package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer = arrayListOf<Int>()

    fun generateAnswer() {
        answer.clear()
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }

    fun compareGuessAndAnswer(userGuess: List<Int>): Boolean {
        TODO()
    }
}