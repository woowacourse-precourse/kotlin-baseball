package baseball

import kotlin.system.exitProcess

object Printer {

    /**
     * 콘솔창에 "숫자 야구 게임을 시작합니다." 출력
     */
    fun printGameStartPhrase() {
        println(Phrase.startGame)
    }

    /**
     * 콘솔창에 "숫자를 입력해주세요 : " 출력
     */
    fun printGuidelinePhrase() {
        print(Phrase.askPlayerToEnterNumber)
    }

    /**
     * 콘솔창에 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
     */
    fun printRetryPhrase() {
        println(Phrase.askPlayerToRetryGame)
    }

    /**
     * 콘솔창에 "예외가 발생되어 프로그램을 종료합니다." 출력
     * 그리고 프로그램 종료
     */
    fun printExceptionPhraseAndQuitProcess() {
        println(Phrase.exceptionIsThrownAndQuitProcess)
        exitProcess(0)
    }

    /**
     * 콘솔창에 "게임을 종료합니다." 출력
     * 그리고 프로그램 종료
     */
    fun printExitGamePhraseAndQuitProcess() {
        println(Phrase.exitGame)
        exitProcess(0)
    }

    /**
     * 콘솔창에 "낫싱" 출력
     */
    fun printNothingPhrase() {
        println(Phrase.nothing)
    }

    /**
     * 콘솔창에 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
     */
    fun printWinGamePhrase() {
        println(Phrase.winGameAndExitGame)
    }

    fun printGameResult(
        resultType: GameResultType
    ) {
        when (resultType) {
            is GameResultType.NormalResult -> printNormalResult(resultType.ball, resultType.strike)
            is GameResultType.NothingResult -> printNothingPhrase()
            is GameResultType.CorrectResult -> {
                printCorrectResult()
                askRetry()
            }
        }
    }

    private fun printNormalResult(
        ballNumber: Int,
        strikeNumber: Int
    ) {
        if (ballNumber != 0 && strikeNumber != 0) {
            println("${ballNumber}볼 ${strikeNumber}스트라이크")
        } else {
            if (ballNumber == 0) {
                println("${strikeNumber}스트라이크")
            } else if (strikeNumber == 0) {
                println("${ballNumber}볼")
            }
        }
    }

    private fun printCorrectResult() {
        println("3스트라이크")
        printWinGamePhrase()
    }

    private fun askRetry() {
        printRetryPhrase()
        Validator(userInput = readln().trim(), ExceptionType.RetryException).validateUserInput()
    }

}