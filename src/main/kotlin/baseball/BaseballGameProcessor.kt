package baseball

import camp.nextstep.edu.missionutils.Console

//interface
class BaseballGameProcessor(
    private val user: User,
    private val computer: Computer,
) : BaseballGameReferee {

    fun processBaseballGame() {
        ScreenManipulator.showMessageToScreen(ScreenManipulator.START_BASEBALLGAME)

        while (true) {
            val guessedNumbers = processGuessNumbers()
            val strikeCount = processCount(guessedNumbers)

            when (decideEachTurn(strikeCount)) {
                GameStatus.TERMINATE -> break
                GameStatus.NEW_GAME -> computer.generateNewRandomNumbers()
                GameStatus.ERROR -> throw IllegalArgumentException("입력 오류입니다.")
                else -> continue
            }
        }
    }

    private fun processCount(guessedNumbers: List<Int>): Int {
        val (strikeCount, ballCount) = arrayOf(
            BallStrikeCounter.calcStrikeCount(computer.randomNumbers, guessedNumbers),
            BallStrikeCounter.calcBallCount(computer.randomNumbers, guessedNumbers)
        )

        ScreenManipulator.showResultToScreen(strikeCount, ballCount)
        return strikeCount
    }

    private fun processGuessNumbers(): List<Int> {
        ScreenManipulator.showMessageToScreen(ScreenManipulator.REQUEST_USER_INPUT)
        val userInput = user.guessNumbers()

        if (!Validator.checkIsValid(userInput)) {
            throw java.lang.IllegalArgumentException("입력 오류입니다.")
        }

        return userInput.toBaseballNumbers()
    }

    /** 사용자의 string 입력을 List<Int>형태로 바꾸어주는 함수 **/
    private fun String.toBaseballNumbers(): List<Int> {
        val guessedNumbers = ArrayList<Int>()

        this.forEach { eachNum ->
            guessedNumbers.add(Character.getNumericValue(eachNum))
        }

        return guessedNumbers.toList()
    }

    override fun decideEachTurn(strikeCount: Int): GameStatus {
        if (strikeCount == 3) {
            return checkPlayAgain()
        }

        return GameStatus.CONTINUE
    }

    override fun checkPlayAgain(): GameStatus {
        val continuingInput = Console.readLine()

        if (!Validator.checkContinuingIsValid(continuingInput)) {
            ScreenManipulator.closeScreen()
            return GameStatus.ERROR
        }

        return if (continuingInput == "1") {
            GameStatus.NEW_GAME
        } else {
            ScreenManipulator.closeScreen()
            GameStatus.TERMINATE
        }
    }
}