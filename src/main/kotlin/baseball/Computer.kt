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
        val strikeCount = countStrike(userGuess)
        val ballCount = countBall(userGuess)
        TODO()
    }

    fun countStrike(userGuess: List<Int>): Int {
        var strikeCount = 0
        for (index in 0..2) {
            if (answer[index] == userGuess[index]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun countBall(userGuess: List<Int>): Int {
        var ballCount = 0
        for (index in 0..2) {
            if (answer[index] == userGuess[index]) continue
            if (answer.contains(userGuess[index])) {
                ballCount++
            }
        }
        return ballCount
    }
}