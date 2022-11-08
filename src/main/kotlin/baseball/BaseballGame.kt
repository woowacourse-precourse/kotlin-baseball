package baseball

class BaseballGame(private val humanPlayer: Player, private var computerPlayer: Player) {
    companion object {
        const val CORRECT_ANSWER = "3스트라이크"
        const val WRONG_ANSWER = ""
    }
}
