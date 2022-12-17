package baseball

private const val NOTHING = "낫싱"
private const val STRIKE = "스트라이크"
private const val BALL = "볼"
private const val ENTER_NUMBER = "숫자를 입력해주세요 : "
private const val START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다."
private const val ALL_RIGHT_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
private const val ENTER_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
private const val ZERO = 0

class Printer() {
    fun showStart() {
        println(START_BASEBALL_GAME)
    }

    fun showInputRequest() {
        print(ENTER_NUMBER)
    }

    private fun showStrikeCount(strikeCount: Int) {
        println("$strikeCount$STRIKE")
    }

    private fun showBallCount(ballCount: Int) {
        println("$ballCount$BALL")
    }

    private fun showNothing() {
        println(NOTHING)
    }

    private fun showBallStrikeCount(ballCount: Int, strikeCount: Int) {
        println("$ballCount$BALL $strikeCount$STRIKE")
    }

    fun showCounting(ballCount: Int, strikeCount: Int) {
        when {
            (strikeCount == ZERO) and (ballCount == ZERO) -> showNothing()
            strikeCount == ZERO -> showBallCount(ballCount)
            ballCount == ZERO -> showStrikeCount(strikeCount)
            else -> showBallStrikeCount(ballCount, strikeCount)
        }
    }

    fun showEnd() {
        println(ALL_RIGHT_GAME_END)
        println(ENTER_RESTART_OR_END)
    }
}
