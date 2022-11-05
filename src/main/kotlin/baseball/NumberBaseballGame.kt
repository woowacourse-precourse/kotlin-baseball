package baseball

class NumberBaseballGame {
    private var strike = 0
    private var ball = 0

    fun calculateScore(computer: List<Int>, player: List<Int>) {
        computer.forEachIndexed { i, computerNumber ->
            player.forEachIndexed { j, playerNumber ->
                if (computerNumber == playerNumber) {
                    if (i == j) {
                        strike += 1
                    } else {
                        ball += 1
                    }
                }
            }
        }
    }
}
