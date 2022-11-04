package baseball.game

interface Game {
    fun start()
    fun askRestart(): Boolean
}