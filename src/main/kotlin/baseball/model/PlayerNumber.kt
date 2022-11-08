package baseball.model

import baseball.Validations

class PlayerNumber {
    fun inputPlayerNumber(startNumber : String): List<Int> {
        val playerNumbers = PlayerNumber().convertStringToList(startNumber)
        if (!Validations.isNumberException(playerNumbers)) {
            throw IllegalArgumentException()
        }
        return playerNumbers
    }

    private fun convertStringToList(inputPlayer: String): List<Int> =
        inputPlayer.toCharArray().map { num -> num.digitToInt() }
}