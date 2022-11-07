package baseball

class GameStrings {
    val GAME_START_TEXT = "숫자 야구 게임을 시작합니다."
    val CORRECT_TEXT = "3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    val REQUEST_INPUT_TEXT = "숫자를 입력해주세요 : "


    fun strikeAndBallCountString(strikeCount: Int, ballCount: Int): String {
        val strikeAndBall = mutableListOf<String>()
        if (ballCount > 0) {
            strikeAndBall.add("${ballCount}볼")
        }
        if (strikeCount > 0) {
            strikeAndBall.add("${strikeCount}스트라이크")
        }


        if (strikeAndBall.isEmpty()) {
            return "낫싱"
        }
        if (strikeCount == 3) {
            return this.CORRECT_TEXT
        }

        return strikeAndBall.joinToString(" ")
    }
}