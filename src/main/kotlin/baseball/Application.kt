package baseball

fun main() {
    PrintMessage().showStartMessage()

    var gameFlag = true
    while (gameFlag) {
        GamePlay().baseballGameStart()
        gameFlag = GamePlay().baseballGameEnd()
    }
}


