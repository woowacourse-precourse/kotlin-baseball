package baseball

import camp.nextstep.edu.missionutils.Console
import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction

object User {
    fun guessNumber(): ArrayList<Int>? {
        val userInput = Console.readLine()
        val isValid = BaseballGameReferee.checkIsValid(userInput)

        return if(isValid)
            userInput.toBaseballNumbers()
        else
            null
    }

    private fun String.toBaseballNumbers(): ArrayList<Int> {
        val guessedNumbers = ArrayList<Int>()

        this.forEach { eachNum ->
            guessedNumbers.add(Character.getNumericValue(eachNum))
        }
        return guessedNumbers
    }
}