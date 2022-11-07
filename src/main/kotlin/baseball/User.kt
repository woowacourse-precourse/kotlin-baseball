package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): MutableList<Int> {
        val userList = mutableListOf<Int>()
        print(INPUT_USER_MESSAGE)
        val input = Console.readLine().toCharArray()
        for(i in input)
            userList.add(i.digitToInt())
        return userList
    }
}