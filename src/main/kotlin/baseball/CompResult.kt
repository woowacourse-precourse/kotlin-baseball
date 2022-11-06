package baseball

class CompResult(computers: List<Int>, users: List<Int>) {
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
            str += "${result[BALL_IDX]}${BALL} "
        }
        if (result[STRIKE_IDX] != 0) {
            str += "${result[STRIKE_IDX]}${STRIKE}"
        }

        return str + "\n"
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