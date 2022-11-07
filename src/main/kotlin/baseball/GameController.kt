package baseball

import model.Computer
import model.User
import util.Constants
import util.Exceptions
import util.Messages


object GameController {
    // 게임에 사용할 model
    private val user = User()
    private val computer = Computer()

    // 사용자가 잘못된 값을 입력한 경우
    fun exception(userList: List<Int>) {
        if (!Exceptions.isValidRange(userList) ||
                !Exceptions.isValidSize(userList) ||
                !Exceptions.hasNotDuplicatedNumber(userList)) {
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

    // 결과에 따라 출력
    fun resultMessage(strike: Int, ball: Int): String {
        return if (strike == 0 && ball == 0) {
            Messages.NOTHING
        } else if (strike == 0) {
            "$ball" + Messages.BALL
        } else if (ball == 0) {
            "$strike" + Messages.STRIKE
        } else {
            "$ball" + Messages.BALL + " $strike" + Messages.STRIKE
        }
    }

}