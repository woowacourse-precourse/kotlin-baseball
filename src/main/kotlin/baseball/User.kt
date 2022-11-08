package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): MutableList<Int> {
        val userList = mutableListOf<Int>()
        print(INPUT_USER_MESSAGE)
        val input = Console.readLine().toCharArray()

        if (!checkSize(input) || !checkNumber(input) || !checkRepeat(input))
            throw IllegalArgumentException()

        for (i in input)
            userList.add(i.digitToInt())
        return userList
    }

    private fun checkNumber(input: CharArray): Boolean {
        for (i in input) {
            if (!i.isDigit())
                return false
        }
        return true
    }

    private fun checkSize(input: CharArray): Boolean {
        if (input.size != 3)
            return false
        return true
    }

    private fun checkRepeat(input: CharArray): Boolean {
        if (input.size != input.distinct().count())
            return false
        return true
    }
}