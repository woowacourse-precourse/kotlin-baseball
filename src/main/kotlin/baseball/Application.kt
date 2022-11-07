package baseball

fun main() {
    val baseballGame = BaseballGame()

    var flag = true
    while(flag) {
        flag = baseballGame.processGame()
    }
}
