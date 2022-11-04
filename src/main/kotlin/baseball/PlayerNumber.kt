package baseball

import camp.nextstep.edu.missionutils.Console

class PlayerNumber {
    fun inputPlayerNumber(): List<Int> {
        val inputPlayer = Console.readLine()
        val playerNumbers = PlayerNumber().convertStringToList(inputPlayer)
        if (!isNumberException(playerNumbers)) {
            throw IllegalArgumentException()
        }
        return playerNumbers
    }

    fun convertStringToList(inputPlayer: String): List<Int> {
        return inputPlayer.toCharArray().map { num -> num - '0' }
    }

    fun inputExitNumber(): String {
        return Console.readLine()
    }

    fun exitGame(): Boolean {
        val endNumber = inputExitNumber()
        if (endNumber == "1") {
            return false
        }
        if (endNumber == "2") {
            return true
        }
        throw IllegalArgumentException()
    }
}