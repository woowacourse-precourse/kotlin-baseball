package baseball.game.service

interface Game {
    fun play()
    fun process()
    fun quit()
    fun retry()
}