package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): MutableList<Int> {
        val userList = mutableListOf<Int>()
        print(INPUT_USER_MESSAGE)
        val input = Console.readLine().toCharArray()

        if (!checkNumber(input))
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


}