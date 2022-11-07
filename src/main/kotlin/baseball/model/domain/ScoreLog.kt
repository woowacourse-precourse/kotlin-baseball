package baseball.model.domain

data class ScoreLog(
    val strike: Int,
    val ball: Int
) {
    fun getScore() = when {
        strike == 0 && ball == 0 -> {
            "낫싱"
        }
        strike != 0 && ball == 0 -> {
            "${strike}스트라이크"
        }
        strike == 0 && ball != 0 -> {
            "${ball}볼"
        }
        else -> {
            "${ball}볼 ${strike}스트라이크"
        }
    }
}
