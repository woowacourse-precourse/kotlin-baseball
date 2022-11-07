package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputUser(): CharArray {
        print(INPUT_USER_MESSAGE)
        return Console.readLine().toCharArray()
    }
}