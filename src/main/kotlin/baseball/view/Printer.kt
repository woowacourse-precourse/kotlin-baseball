package baseball.view

import baseball.utils.Constant.INPUT_MESSAGE
import baseball.utils.Constant.QUIT_GAME_MESSAGE
import baseball.utils.Constant.RESULT_BALL_AND_STRIKE_MESSAGE
import baseball.utils.Constant.RESULT_BALL_MESSAGE
import baseball.utils.Constant.RESULT_NOTHING_MESSAGE
import baseball.utils.Constant.RESULT_STRIKE_MESSAGE
import baseball.utils.Constant.RETRY_GAME_MESSAGE
import baseball.utils.Constant.START_GAME_MESSAGE
import baseball.utils.Constant.WIN_GAME_MESSAGE

object Printer {

    /**
     * 콘솔창에 "숫자 야구 게임을 시작합니다." 출력
     */
    fun printGameStartPhrase() {
        println(START_GAME_MESSAGE)
    }

    /**
     * 콘솔창에 "숫자를 입력해주세요 : " 출력
     */
    fun printGuidelinePhrase() {
        print(INPUT_MESSAGE)
    }

    /**
     * 콘솔창에 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
     */
    fun printRetryPhrase() {
        println(RETRY_GAME_MESSAGE)
    }

    /**
     * 콘솔창에 "게임을 종료합니다." 출력
     * 그리고 프로그램 종료
     */
    fun printExitGamePhrase() {
        println(QUIT_GAME_MESSAGE)
    }

    /**
     * 콘솔창에 "낫싱" 출력
     */
    fun printNothingPhrase() {
        println(RESULT_NOTHING_MESSAGE)
    }

    /**
     * 콘솔창에 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
     */
    fun printWinGamePhrase() {
        println(WIN_GAME_MESSAGE)
    }

    fun printNormalResult(
        ballNumber: Int,
        strikeNumber: Int
    ) {

        if (ballNumber != 0 && strikeNumber != 0) {
            println(RESULT_BALL_AND_STRIKE_MESSAGE.format(ballNumber, strikeNumber))
        } else if (ballNumber == 0 && strikeNumber != 0) {
            println(RESULT_STRIKE_MESSAGE.format(strikeNumber))
        } else if (ballNumber != 0 && strikeNumber == 0) {
            println(RESULT_BALL_MESSAGE.format(ballNumber))
        }
    }
}