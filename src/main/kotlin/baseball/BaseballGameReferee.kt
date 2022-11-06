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


}