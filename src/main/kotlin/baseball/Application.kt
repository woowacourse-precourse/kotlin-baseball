package baseball

fun main() {
    while (true) {
        val game = Game()
        if (game.playBaseball()) {
            break
        }
    }
}
