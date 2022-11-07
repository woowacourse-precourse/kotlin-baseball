package baseball

class Hint(private val computer: List<Int>) {
    var strikeNum = 0
    var ballNum = 0

    fun calculateStrike(player: String) {
        var count = 0
        for (i in computer.indices) {
            val computerNumber = computer[i]
            val playerNumber = player[i] - '0'
            if (computerNumber == playerNumber)
                count++
        }
        this.strikeNum = count
    }

    fun calculateBall(player: String) {
        var count = 0
        for (playerCharacter in player) {
            val playerNumber = playerCharacter - '0'
            if (computer.contains(playerNumber))
                count++
        }
        this.ballNum = count - strikeNum
    }
}