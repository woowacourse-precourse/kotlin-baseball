package baseball

fun processBaseballGame() {
    Computer.generateNewRandomNumbers()
    ScreenManipulator.printGameStart()

    while (true) {
        val guessedNumbers = User.guessNumber() ?: throw IllegalArgumentException("입력 오류입니다.")
        val (strikeCount, ballCount) = arrayOf(BaseballGameReferee.calcStrikeCount(guessedNumbers),
            BaseballGameReferee.calcBallCount(guessedNumbers))

        when (BaseballGameReferee.decideEachTurn(strikeCount, ballCount)) {
            GameStatus.TERMINATE -> break
            GameStatus.NEW_GAME -> Computer.generateNewRandomNumbers()
            GameStatus.ERROR -> throw IllegalArgumentException("입력 오류입니다.")
            else -> continue
        }
    }
}

fun main() {
    processBaseballGame()
}
