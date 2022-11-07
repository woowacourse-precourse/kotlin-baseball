package baseball

import java.io.BufferedWriter
import java.io.OutputStreamWriter

object ScreenManipulator {
    private lateinit var screen: BufferedWriter
    private const val MSG_STRIKE = "스트라이크 "
    private const val MSG_BALL = "볼 "
    private const val THREE_STRIKE_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    private const val NOTHING = "낫싱"
    const val START_BASEBALLGAME = "숫자 야구 게임을 시작합니다.\n"
    const val REQUEST_USER_INPUT = "숫자를 입력해주세요 : "

    fun showResultToScreen(strikeCount: Int, ballCount: Int) {
        if (ballCount > 0) {
            showBallCount(ballCount)
        }
        when {
            strikeCount + ballCount == 0 -> showMessageToScreen(NOTHING)
            strikeCount == 3 -> {
                showStrikeCount(strikeCount)
                showNewLine()
                showMessageToScreen(THREE_STRIKE_GAME_END)
            }
            strikeCount in 1..2 -> showStrikeCount(strikeCount)
        }
        showNewLine()
    }

    fun showMessageToScreen(msg:String){
        if(msg== START_BASEBALLGAME){
            screen= BufferedWriter(OutputStreamWriter(System.`out`))
        }
        screen.write(msg)
        screen.flush()
    }

    private fun showStrikeCount(strikeCount: Int) {
        screen.write("${strikeCount}${MSG_STRIKE}")
        screen.flush()
    }

    private fun showBallCount(ballCount: Int) {
        screen.write("${ballCount}${MSG_BALL}")
        screen.flush()
    }

    private fun showNewLine(){
        screen.write("\n")
        screen.flush()
    }

    fun closeScreen() {
        screen.close()
    }
}