package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

val gameStrings = GameStrings()
lateinit var answer: Answer

class Answer(answer: String) {
    val answer: String

    init {
        if (answer.length != 3) {
            throw IllegalArgumentException("number's digit should be 3.")
        }
        if (checkDup(answer)) {
            throw IllegalArgumentException("each number in answer should be unique.")
        }
        this.answer = answer
    }

    private fun checkDup(answer: String): Boolean {

        val checkDup= mutableListOf<Char>()
        for(i in answer) checkDup.add(i)

        if(answer.length!=checkDup.distinct().size){
            return true
        }

        return false
    }
}

class PlayersGuess(playerGuess: String) {
    val guess: String

    init {
        if (playerGuess.length != 3) {
            throw IllegalArgumentException("number's digit should be 3.")
        }
        this.guess = playerGuess
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
    var generateNumber = ""
    while (generateNumber.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!generateNumber.contains(randomNumber.digitToChar())) {
            generateNumber += randomNumber
        }
    }

    answer = Answer(generateNumber)
}

fun prepareNewGame() {
    setRandomNumber()
}

fun countBallAndStrike(playersGuess: PlayersGuess): List<Int> {
    var strikeCount = 0
    var ballCount = 0

    for (i in 0 until 3) {
        val containment = answer.answer.contains(playersGuess.guess[i])

        if (containment && answer.answer[i] == playersGuess.guess[i]) {
            strikeCount++
        } else if (containment) {
            ballCount++
        }

    }


    return listOf(strikeCount, ballCount)
}

fun playGame() {
    lateinit var playerAnswer: PlayersGuess


    while (true) {
        print(gameStrings.REQUEST_INPUT_TEXT)
        playerAnswer = PlayersGuess(readln())

        val (strikeCount, ballCount) = countBallAndStrike(playerAnswer)
        println(gameStrings.strikeAndBallCountString(strikeCount, ballCount))

        if (strikeCount == 3) {
            return
        }
    }

}

fun decideNewGameOrEnd(input: NewGameOrEnd): Boolean {
    return input.input != 1
}


fun main() {
    println(gameStrings.GAME_START_TEXT)
    while (true) {

        prepareNewGame()
        playGame()

        val newGameOrEnd = NewGameOrEnd(readln().toInt())
        if (decideNewGameOrEnd(newGameOrEnd)) {
            break
        }
    }


}