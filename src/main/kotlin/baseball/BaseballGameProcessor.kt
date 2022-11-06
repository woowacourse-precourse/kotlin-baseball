package baseball

class BaseballGameProcessor(private val user: User, private val computer: Computer) {
    fun baseballGameProcess() {
        ScreenManipulator.printGameStart()

        while (true) {
            val userInput = user.guessNumbers()

            if (!Validator.checkIsValid(userInput)) {
                throw java.lang.IllegalArgumentException("입력 오류입니다.")
            }

            val guessedNumbers = userInput.toBaseballNumbers()
            val (strikeCount, ballCount) = arrayOf(BSCounter.calcStrikeCount(computer.randomNumbers, guessedNumbers),
                BSCounter.calcBallCount(computer.randomNumbers, guessedNumbers))

            when (BaseballGameReferee.decideEachTurn(strikeCount, ballCount)) {
                GameStatus.TERMINATE -> break
                GameStatus.NEW_GAME -> computer.generateNewRandomNumbers()
                GameStatus.ERROR -> throw IllegalArgumentException("입력 오류입니다.")
                else -> continue
            }
        }
    }

    private fun String.toBaseballNumbers(): List<Int> {
        val guessedNumbers = ArrayList<Int>()

        this.forEach { eachNum ->
            guessedNumbers.add(Character.getNumericValue(eachNum))
        }

        return guessedNumbers.toList()
    }

}