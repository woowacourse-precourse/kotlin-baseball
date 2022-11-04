package baseball

import baseball.view.InputView

class PlayerNumber {
    fun inputPlayerNumber(): List<Int> {
        val startNumber = InputView().startPlayerNumber()
        val playerNumbers = PlayerNumber().convertStringToList(startNumber)
        if (!isNumberException(playerNumbers)) {
            throw IllegalArgumentException()
        }
        return playerNumbers
    }

    fun convertStringToList(inputPlayer: String): List<Int> {
        return inputPlayer.toCharArray().map { num -> num - '0' }
    }

    fun exitGame(): Boolean {
        val endNumber = InputView().startPlayerNumber()
        if (endNumber == "1") {
            return false
        }
        if (endNumber == "2") {
            return true
        }
        throw IllegalArgumentException()
    }
}