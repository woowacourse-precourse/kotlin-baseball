package baseball

import camp.nextstep.edu.missionutils.Console
import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction

object User {
    fun guessNumber(): ArrayList<Int>? {
        val userInput = Console.readLine()

        try {
            BaseballGameReferee.checkException(userInput)
        } catch (error: IllegalArgumentException) {
            error.printStackTrace()
            return null
        }
        return userInput.toBaseballNumbers()
    }

    private fun String.toBaseballNumbers(): ArrayList<Int> {
        val guessedNumbers = ArrayList<Int>()

        this.forEach { eachNum ->
            guessedNumbers.add(Character.getNumericValue(eachNum))
        }
        return guessedNumbers
    }

}