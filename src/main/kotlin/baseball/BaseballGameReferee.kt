package baseball

import camp.nextstep.edu.missionutils.Console

object BaseballGameReferee {
    /** 사용자가 추측한 숫자에 따라 게임이 계속 진행되어야 하는지 판단하는 함수 **/
    fun decideEachTurn(strikeCount: Int): GameStatus {
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
}