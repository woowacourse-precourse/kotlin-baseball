package baseball

class Result {

    fun printResult(strikeCount: Int, ballCount: Int) {
        if (strikeCount == 0 && ballCount == 0) {
            PrintForm().printNothing()
        }
        if (strikeCount == GAME_CLEAR) {
            PrintForm().printWhen3Strike(strikeCount)
        }
        if (strikeCount in 1 until INPUT_LENGTH_STANDARD && ballCount in 1 until INPUT_LENGTH_STANDARD) {
            PrintForm().printStrikeAndBall(ballCount, strikeCount)
        }
        if (strikeCount in 1 until INPUT_LENGTH_STANDARD && ballCount == 0) {
            PrintForm().printOnlyStrike(strikeCount)
        }
        if (strikeCount == 0 && ballCount in 1..INPUT_LENGTH_STANDARD) {
            PrintForm().printOnlyBall(ballCount)
        }
    }
}