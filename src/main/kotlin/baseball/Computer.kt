package baseball

import camp.nextstep.edu.missionutils.Randoms

private const val NOTHING_MESSAGE = "낫싱"
private const val BALL_MESSAGE = "볼"
private const val STRIKE_MESSAGE = "스트라이크"
private const val CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
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
        val result = StringBuilder()

        if (ballCount == 0 && strikeCount == 0) {
            result.append(NOTHING_MESSAGE)
            println(result.toString())
            return true
        }
        if (ballCount > 0) {
            result.append(ballCount).append(BALL_MESSAGE)
            if (strikeCount > 0) {
                result.append(' ')
            }
        }
        if (strikeCount > 0) {
            result.append(strikeCount).append(STRIKE_MESSAGE)
        }
        if (strikeCount == ANSWER_COUNT) {
            result.append('\n').append(CORRECT_MESSAGE)
            println(result.toString())
            return false
        }
        println(result.toString())
        return true
    }

    fun countStrike(userGuess: List<Int>): Int {
        var strikeCount = 0
        for (index in 0 until ANSWER_COUNT) {
            if (answer[index] == userGuess[index]) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun countBall(userGuess: List<Int>): Int {
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