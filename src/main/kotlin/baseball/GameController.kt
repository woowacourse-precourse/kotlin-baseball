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

    // 스트라이크 -> 위치와 숫자가 모두 같음
    fun getStrikeCount(computer: List<Int>, user: List<Int>): Int {
        return user.filterIndexed { index, number ->
            computer[index] == number
        }.count()
    }

    // 볼 -> 위치는 다르지만 숫자가 포함
    fun getBallCount(computer: List<Int>, user: List<Int>): Int {
        var ball = 0
        // 위치와 숫자가 같은 부분 필터링
        val filterList = computer.filterIndexed { index, computerNumber ->
            user[index] != computerNumber
        }
        user.forEach { number ->
            if (filterList.contains(number)) {
                ball++
            }
        }
        return ball
    }
}