package baseball

import camp.nextstep.edu.missionutils.Randoms

const val ANSWER_COUNT = 3
const val MIN_NUMBER = 1
const val MAX_NUMBER = 9

class Computer {
    private var answer = arrayListOf<Int>()

    fun generateAnswer() {
        answer.clear()
        while (answer.size < ANSWER_COUNT) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }

    fun compareGuessAndAnswer(userGuess: List<Int>): Boolean {
        val strikeCount = countStrike(userGuess)
        val ballCount = countBall(userGuess)

        if (strikeCount == ANSWER_COUNT){
            UserView.printCorrectFinishGame()
            return false
        }
        if (ballCount == 0 && strikeCount == 0) {
            UserView.printNothing()
            return true
        }
        if (ballCount > 0 && strikeCount > 0){
            UserView.printBallAndStrike(ballCount, strikeCount)
            return true
        }
        if (ballCount > 0) {
            UserView.printBall(ballCount)
            return true
        }
        if (strikeCount > 0) {
            UserView.printStrike(strikeCount)
            return true
        }
        return true
    }

    private fun countStrike(userGuess: List<Int>): Int {
        var strikeCount = 0
        for (index in 0 until ANSWER_COUNT) {
            if (answer[index] == userGuess[index]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    private fun countBall(userGuess: List<Int>): Int {
        var ballCount = 0
        for (index in 0 until ANSWER_COUNT) {
            if (answer[index] == userGuess[index]) continue
            if (answer.contains(userGuess[index])) {
                ballCount++
            }
        }
        return ballCount
    }
}