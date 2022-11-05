package baseball.model

import baseball.controller.BaseBallController
import baseball.view.InputView

class PlayerNumber {
    fun inputPlayerNumber(): List<Int> {
        val startNumber = InputView().startPlayerNumber()
        val playerNumbers = PlayerNumber().convertStringToList(startNumber)
        if (!BaseBallController().isNumberException(playerNumbers)) {
            throw IllegalArgumentException()
        }
        return playerNumbers
    }

    fun convertStringToList(inputPlayer: String): List<Int> {
        return inputPlayer.toCharArray().map { num -> num - '0' }
    }
}