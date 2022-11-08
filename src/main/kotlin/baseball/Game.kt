package baseball

import camp.nextstep.edu.missionutils.Console

class Game {

    // 게임 종료 시 실행됨, 게임 종료 여부 판단 후 불린 값 리턴
    var onEnd: () -> Boolean = { true }

    fun playWith(computer: List<Int>): Boolean {
        var matched = false
        while (!matched) {
            print("숫자를 입력해주세요 : ")
            val user = Console.readLine()
            validateUserInput(user)

            val result = Result(computer, splitUserInput(user))
            println(result.toString())

            matched = result.allMatched()
        }

        return onEnd()
    }

    fun validateUserInput(input: String) {
        val nums = input.toList()

        if (nums.size != 3 ||
            nums.any { it !in '1'..'9' } ||
            nums.distinct() != nums
        ) {
            throw IllegalArgumentException("1부터 9사이의 수로 이루어진 중복 없는 수를 입력해주세요 ")
        }
    }

    fun splitUserInput(input: String) =
        input.toList()
            .map { it.digitToInt() }

    class Result(computers: List<Int>, users: List<Int>) {
        private val result = compare(computers, users)

        private fun compare(computers: List<Int>, users: List<Int>): IntArray {
            val ballStrikeCnt = intArrayOf(0, 0)
            for (idx in users.indices) {
                val userNum = users[idx]

                if (userNum == computers[idx]) {
                    ballStrikeCnt[STRIKE_IDX] += 1
                } else if (computers.contains(userNum)) {
                    ballStrikeCnt[BALL_IDX] += 1
                }
            }
            return ballStrikeCnt
        }

        override fun toString(): String {
            if (result[BALL_IDX] == 0 && result[STRIKE_IDX] == 0) {
                return NOTHING
            }

            var str = ""
            if (result[BALL_IDX] != 0) {
                str += "${result[BALL_IDX]}$BALL"
                if (result[STRIKE_IDX] != 0) {
                    str += " "
                }
            }
            if (result[STRIKE_IDX] != 0) {
                str += "${result[STRIKE_IDX]}$STRIKE"
            }

            return str
        }

        fun allMatched() = result[STRIKE_IDX] == 3

        companion object {
            private const val BALL_IDX = 0
            private const val STRIKE_IDX = 1
            private const val BALL = "볼"
            private const val STRIKE = "스트라이크"
            private const val NOTHING = "낫싱"
        }
    }
}
