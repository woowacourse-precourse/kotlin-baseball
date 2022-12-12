package baseball.domain

class Referee {
    fun continueGame(ball: Int, strike: Int): Boolean {
        if (ball == 0
            && strike == 3) {
            return false
        }
        return true
    }
}