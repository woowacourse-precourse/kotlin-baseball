package baseball

import java.io.BufferedWriter
import java.io.OutputStreamWriter

object ScreenManipulator {
    lateinit var screen: BufferedWriter

    fun manipulateScreen(strikeCount: Int, ballCount: Int) {
        if (ballCount > 0) {
            printBallCount(ballCount)
        }
        when {
            strikeCount + ballCount == 0 -> printNothing()
            strikeCount == 3 -> {
                printStrikeCount(strikeCount)
                printNewLine()
                printGameEnd()
            }
            strikeCount in 1..2 -> printStrikeCount(strikeCount)
        }
        printNewLine()
    }

    fun printGameStart() {
        screen = BufferedWriter(OutputStreamWriter(System.`out`))
        screen.write("숫자 야구 게임을 시작합니다.\n")
        screen.flush()
    }

    fun printRequestUserInput() {
        screen.write("숫자를 입력해주세요 : ")
        screen.flush()
    }

    private fun printNewLine() {
        screen.write("\n")
        screen.flush()
    }

    private fun printStrikeCount(strikeCount: Int) {
        screen.write("${strikeCount}스트라이크 ")
        screen.flush()
    }

    private fun printBallCount(ballCount: Int) {
        screen.write("${ballCount}볼 ")
        screen.flush()
    }

    private fun printGameEnd() {
        screen.write("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        screen.flush()
    }

    private fun printNothing() {
        screen.write("낫싱")
        screen.flush()
    }

    fun screenClose() {
        screen.close()
    }
}