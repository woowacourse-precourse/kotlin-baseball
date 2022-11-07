package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {
    data class Score(var strike: Int, var ball: Int)

    private val guessRegex = "[1-9]{3}".toRegex()

    private var score: Score = Score(0, 0)
    private var progressStatus = RUNNING
    private fun generateAnswer(): String {
        val answerList = mutableListOf<Int>()
        while (answerList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (answerList.contains(randomNumber).not()) {
                answerList.add(randomNumber)
            }
        }
        return answerList.joinToString("")
    }

    private fun inputUserGuess(): String {
        val guess = Console.readLine()
        if (checkValidGuess(guess).not()) {
            throw IllegalArgumentException("exception")
        }
        return guess
    }
    private fun checkValidGuess(guess: String) = guessRegex.matches(guess) && guess.toSet().size == 3

    private fun checkGameOver(score: Score) = score.strike == 3

    private fun gradeGuess(answer: String, guess: String): Score {
        val score = Score(0, 0)

        for (i in 0..2) {
            when {
                guess[i] == answer[i] -> score.strike += 1
                guess[i] in answer -> score.ball += 1
            }
        }
        return score
    }

    private fun printGuide() {
        println("숫자 야구 게임을 시작합니다.")
        print("숫자를 입력해주세요 : ")
    }

    private fun printScore(score: Score) {
        score.apply {
            when {
                strike != 0 && ball != 0 -> "${ball}볼 ${strike}스트라이크"
                strike != 0 -> "${strike}스트라이크"
                ball != 0 -> "${ball}볼"
                else -> "낫싱"
            }.let { println(it) }
        }
    }

    private fun printGameOverMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
    companion object {
        private const val RUNNING = 1
        private const val RESTART = 2
        private const val END = -1
    }
}
