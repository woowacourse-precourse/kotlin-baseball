package baseball.domain

class Game(var strike: Int = 0, var ball: Int = 0) {

    private val answerNumbers = ComputerNumbers()

    fun compareNumbers(userNumber: List<Int>) {
        userNumber.onEachIndexed { index, number ->
            if (number == answerNumbers[index]) {
                strike += 1
            } else if (answerNumbers.contains(number)) {
                ball += 1
            }
        }
    }

    fun resetScore() {
        strike = 0
        ball = 0
    }
}
