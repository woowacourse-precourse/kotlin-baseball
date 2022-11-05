package baseball.model

import baseball.Validations
import baseball.view.InputView

class PlayerNumber {
    fun inputPlayerNumber(): List<Int> {
        val startNumber = InputView().startPlayerNumber()
        val playerNumbers = PlayerNumber().convertStringToList(startNumber)
        if (!Validations.isNumberException(playerNumbers)) {
            throw IllegalArgumentException()
        }
        return playerNumbers
    }

    private fun convertStringToList(inputPlayer: String): List<Int> {
        return inputPlayer.toCharArray().map { num -> num - '0' }
    }
}