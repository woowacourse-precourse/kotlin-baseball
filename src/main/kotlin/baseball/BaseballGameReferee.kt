package baseball

import camp.nextstep.edu.missionutils.Console

object BaseballGameReferee {
    /** 각 턴마다 사용자의 입력에 따른 결과를 판단하는 함수 **/
    fun decideEachTurn(strikeCount: Int, ballCount: Int): GameStatus {
        manipulateScreen(strikeCount, ballCount)
        if (strikeCount == 3) {
            return checkPlayAgain()
        }

        return GameStatus.CONTINUE
    }

    /** 사용자의 입력이 규칙에 적합한지 확인하는 함수 **/
    fun checkIsValid(userInput: String): Boolean {
        var isValid = true

        when {
            userInput.length != 3 -> isValid = false
            !userInput.isNumeric() -> isValid = false
            !userInput.hasOverlappedNumbers() -> isValid = false
            userInput.contains('0') -> isValid = false
        }

        if (!isValid) {
            ScreenManipulator.screenClose()
        }
        return isValid
    }

    private fun checkPlayAgain(): GameStatus {
        return when (Console.readLine()) {
            "1" -> GameStatus.NEW_GAME
            "2" -> {
                ScreenManipulator.screenClose()
                GameStatus.TERMINATE
            }
            else -> {
                ScreenManipulator.screenClose()
                GameStatus.ERROR
            }
        }
    }

    private fun manipulateScreen(strikeCount: Int, ballCount: Int) {
        if (ballCount > 0) {
            ScreenManipulator.printBallCount(ballCount)
        }
        when {
            strikeCount + ballCount == 0 -> ScreenManipulator.printNothing()
            strikeCount == 3 -> {
                ScreenManipulator.printStrikeCount(strikeCount)
                ScreenManipulator.printGameEnd()
            }
            strikeCount in 1..2 -> ScreenManipulator.printStrikeCount(strikeCount)
        }
        ScreenManipulator.printNewLine()
    }

    /** 사용자의 입력에 숫자가 아닌 것들이 존재하는지 확인하기 위한 함수 **/
    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
    }

    /** 중복된 숫자들이 있는지 확인하는 함수 **/
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