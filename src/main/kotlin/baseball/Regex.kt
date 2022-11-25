package baseball

import java.lang.IllegalArgumentException
import java.util.regex.Pattern

class Regex {

    fun checkNumberIsContained(type: String, number: Int?, numberList: List<Int>): Boolean {
        var mReturn = false
        if (type == "User") {
            mReturn = numberList.distinct().size == numberList.size //Set 사용 검토!
        }
        if (type == "Rand") {
            mReturn = numberList.contains(number)
        }
        return mReturn
    }

    fun checkInputRegex(input: String): List<Int> {
        val inputToList = input.split("").filter { it != "" }

        if (!checkInputIsNumber(input)) {
            throw IllegalArgumentException()
        }
        if (input.length != INPUT_LENGTH_STANDARD) {
            throw IllegalArgumentException()
        }
        if (!Regex().checkNumberIsContained("User", null, convertStringListToIntList(inputToList))) {
            print("contain")
            throw IllegalArgumentException()
        }
        return convertStringListToIntList(inputToList)
    }

    fun checkInputIsNumber(number: String): Boolean {
        return Pattern.matches("^[1-9]*$", number)
    }

    private fun convertStringListToIntList(targetList: List<String>): List<Int> {
        return targetList.map { it.toInt() }
    }
}