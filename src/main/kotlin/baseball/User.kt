package baseball

import camp.nextstep.edu.missionutils.Console
import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction

object User {
    fun guessNumbers(): String = Console.readLine()

    fun toBaseballNumbers(userInput : String): ArrayList<Int> {
        val guessedNumbers = ArrayList<Int>()

        userInput.forEach { eachNum ->
            guessedNumbers.add(Character.getNumericValue(eachNum))
        }
        return guessedNumbers
    }
}