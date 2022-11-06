package baseball

import util.Exceptions


object GameController {

    // 사용자가 잘못된 값을 입력한 경우
    fun exception(userList: List<Int>) {
        if (Exceptions.isValidRange(userList) ||
                Exceptions.isValidSize(userList) ||
                Exceptions.hasNotDuplicatedNumber(userList)) {
            throw IllegalArgumentException()
        }
    }
}