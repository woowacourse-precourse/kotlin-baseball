package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    lateinit var number: List<Int>
    lateinit var input: String
    lateinit var reStartOrEndChoice: String

    fun getInputFromKeyboard(): String = Console.readLine()

    fun getUserNumber(input: String): List<Int> {
        return input.map { char ->
            char.digitToInt()
        }
    }
}
