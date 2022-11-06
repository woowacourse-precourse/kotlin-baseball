package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

val gameStrings = GameStrings()
lateinit var answer: String

class PlayersAnswer(playerAnswer: String) {
    val answer: String

    init {
        if (playerAnswer.length != 3) {
            throw IllegalArgumentException("number's digit should be 3.")
        }
        this.answer = playerAnswer
    }
}

class NewGameOrEnd(playerInput: Int) {
    val input: Int

    init {
        if (playerInput != 1 && playerInput != 2) {
            throw IllegalArgumentException("input should be 1 or 2.")
        }
        this.input = playerInput
    }
}


fun setRandomNumber() {
    answer = ""
    while (answer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber.digitToChar())) {
            answer += randomNumber
        }
    }
}

fun prepareNewGame() {
    setRandomNumber()
}

fun countBallAndStrike(playersAnswer: PlayersAnswer): List<Int> {
    var strikeCount = 0
    var ballCount = 0

    for (i in 0 until 3) {
        val containment = answer.contains(playersAnswer.answer[i])

        if (containment && answer[i] == playersAnswer.answer[i]) {
            strikeCount++
        } else if (containment) {
            ballCount++
        }

    }


    return listOf(strikeCount, ballCount)
}

fun playGame() {
    lateinit var playerAnswer: PlayersAnswer

    while (true) {
        print(gameStrings.REQUEST_INPUT_TEXT)
        playerAnswer = PlayersAnswer(readln())

        val (strikeCount, ballCount) = countBallAndStrike(playerAnswer)

        if (strikeCount == 3) {
            println(gameStrings.CORRECT_TEXT)
            return
        } else {
            gameStrings.printStrikeAndBallCount(strikeCount, ballCount)
        }
    }

}


fun main() {
    lateinit var newGameOrEnd: NewGameOrEnd

    println(gameStrings.GAME_START_TEXT)
    do {
        prepareNewGame()
        playGame()
        newGameOrEnd = NewGameOrEnd(readln().toInt())

    } while (newGameOrEnd.input == 1)


}