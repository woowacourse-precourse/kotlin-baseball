package baseball

class Printer() {
    fun showStart() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun showInputRequest() {
        print("숫자를 입력해주세요 : ")
    }

    private fun showStrikeCount(strikeCount: Int) {
        println("${strikeCount}스트라이크")
    }

    private fun showBallCount(ballCount: Int) {
        println("${ballCount}볼")
    }

    private fun showNothing() {
        println("낫싱")
    }

    private fun showBallStrikeCount(ballCount: Int, strikeCount: Int) {
        println("${ballCount}볼 ${strikeCount}스트라이크")
    }

    fun showCounting(ballCount: Int, strikeCount: Int) {
        when {
            (strikeCount == 0) and (ballCount == 0) -> showNothing()
            strikeCount == 0 -> showBallCount(ballCount)
            ballCount == 0 -> showStrikeCount(strikeCount)
            else -> showBallStrikeCount(ballCount, strikeCount)
        }
    }

    fun showEnd() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}
