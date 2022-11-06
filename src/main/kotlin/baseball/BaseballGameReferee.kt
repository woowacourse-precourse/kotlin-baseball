package baseball

import camp.nextstep.edu.missionutils.Console

object BaseballGameReferee {
    fun processBaseballGame() {
        Computer.generateNewRandomNumbers()
        WordPrinter.printGameStart()

        while (true) {
            val guessedNumbers = User.guessNumber() ?: return
            lateinit var curGameStatus: GameStatus

            try {
                val (strikeCount, ballCount) = arrayOf(calcStrikeCount(guessedNumbers), calcBallCount(guessedNumbers))
                curGameStatus = decideEachTurn(strikeCount, ballCount)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                return
            }
            when (curGameStatus) {
                GameStatus.TERMINATE -> break
                GameStatus.NEW_GAME -> Computer.generateNewRandomNumbers()
                else -> continue
            }
        }
    }

    private fun manipulateScreen(strikeCount: Int, ballCount: Int) {
        if (ballCount > 0) {
            WordPrinter.printBallCount(ballCount)
        }

        when {
            strikeCount + ballCount == 0 -> WordPrinter.printNothing()
            strikeCount == 3 -> {
                WordPrinter.printStrikeCount(strikeCount)
                WordPrinter.printGameEnd()
            }
            strikeCount in 1..2 -> WordPrinter.printStrikeCount(strikeCount)
        }
        WordPrinter.printNewLine()
    }

    private fun decideEachTurn(strikeCount: Int, ballCount: Int): GameStatus {
        manipulateScreen(strikeCount, ballCount)

        if (strikeCount == 3) {
            return checkPlayAgain()
        }

        return GameStatus.CONTINUE
    }

    private fun checkPlayAgain(): GameStatus {
        return when (Console.readLine()) {
            "1" -> GameStatus.NEW_GAME
            "2" -> GameStatus.TERMINATE
            else -> throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }

    fun calcStrikeCount(userInput: ArrayList<Int>): Int {
        var strikeCount = 0

        userInput.forEachIndexed { index, eachNum ->
            if (Computer.randomNumbers[index] == eachNum) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun calcBallCount(userInput: ArrayList<Int>): Int {
        var ballCount = 0

        userInput.forEachIndexed { userNumberIndex, userNum ->
            ballCount += Computer.randomNumbers.filterIndexed { computerNumberIndex, _ -> computerNumberIndex != userNumberIndex }
                .filter { computerNumber -> computerNumber == userNum }.size
        }
        return ballCount
    }

    fun checkException(userInput: String) {
        var isValid = true

        when {
            userInput.length != 3 -> isValid = false
            !userInput.isNumeric() -> isValid = false
            !userInput.hasOverlappedNumbers() -> isValid = false
            userInput.contains('0') -> isValid = false
        }

        if (!isValid) {
            throw IllegalArgumentException("입력 오류입니다.")
        }
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
    }

    private fun String.hasOverlappedNumbers(): Boolean {
        val usedNumberSet = mutableSetOf<Char>()

        this.forEach { eachNum ->
            if (usedNumberSet.contains(eachNum)) {
                return false
            }
            usedNumberSet.add(eachNum)
        }
        return true
    }
}