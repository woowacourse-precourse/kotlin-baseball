package baseball

import baseball.Printer.printExceptionPhraseAndQuitProcess
import baseball.Printer.printGameResult
import kotlin.system.exitProcess

class Validator(
    private val userInput: String,
    private val exceptionType: ExceptionType
) {

    fun validateUserInput() {
        when(exceptionType) {
            is ExceptionType.GameException -> {
                try {
                    if (
                        userInput.isNotException(exceptionType) &&
                        userInput.isNotDuplicated()
                    ) {
                        printGameResult(userInput.gameResult())
                    } else {
                        throw IllegalArgumentException()
                    }
                } catch (ex: IllegalArgumentException) {
                    printExceptionPhraseAndQuitProcess()
                }
            }
            is ExceptionType.RetryException -> {
                try {
                    if (userInput.isNotException(exceptionType)) {
                        when (userInput) {
                            "1" -> Referee.gameStart()
                            "2" -> {
                                println(Phrase.exitGame)
                                exitProcess(0)
                            }
                        }
                    } else {
                        throw IllegalArgumentException()
                    }
                } catch (ex: IllegalArgumentException) {
                    printExceptionPhraseAndQuitProcess()
                }
            }
        }
    }
}

