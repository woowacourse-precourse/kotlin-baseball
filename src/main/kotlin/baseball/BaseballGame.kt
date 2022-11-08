package baseball

class BaseballGame(private val humanPlayer: Player, private var computerPlayer: Player) {
    companion object {
        const val CORRECT_ANSWER = "3스트라이크"
        const val WRONG_ANSWER = ""
        const val RESTART_GAME = "1"
        const val TERMINATE_GAME = "2"
    }
}
