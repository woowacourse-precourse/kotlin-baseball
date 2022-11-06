package util

import util.Constants.MAX_SIZE
import util.Constants.RANGE_END
import util.Constants.RANGE_START

object Exceptions {
    // 사용자 숫자 리스트의 크기 확인
    fun isValidSize(userList: List<Int>) = userList.size == MAX_SIZE

    // 사용자 중복 숫자 확인
    fun hasNotDuplicatedNumber(userList: List<Int>) = userList.size == userList.toSet().size

    // 사용자 숫자 범위 확인 (1~9)
    fun isValidRange(userList: List<Int>): Boolean {
        userList.forEach { number ->
            if (number < RANGE_START || RANGE_END < number) {
                return false
            }
        }
        return true
    }
}