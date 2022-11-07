package baseball

import baseball.Computer.generateRandomNumber
import baseball.Printer.printGameStartPhrase
import baseball.Printer.printGuidelinePhrase

object Referee {

    init {
        printGameStartPhrase()
    }

    fun gameStart() {
        generateRandomNumber()
        processBaseBallGame()
    }

    private fun processBaseBallGame() {
        while (true) {
            printGuidelinePhrase()
            Validator(userInput = readln().trim(), exceptionType = ExceptionType.GameException).validateUserInput()
        }
    }
}