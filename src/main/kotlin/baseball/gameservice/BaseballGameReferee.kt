package baseball.gameservice

import baseball.data.GameStatus

//interface
interface BaseballGameReferee {
    /** 사용자가 추측한 숫자에 따라 게임이 계속 진행되어야 하는지 판단하는 함수 **/
    fun decideEachTurn(strikeCount: Int): GameStatus
    fun checkPlayAgain(): GameStatus
}