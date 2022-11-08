package baseball

fun main() {
    doGame()
}

fun doGame() {
    var number = Number()
    var result = Result()

    println("숫자 야구 게임을 시작합니다.")

    while (result.chooseGameNum == Result.RESTART_GAME) {
        var computerNum = number.getComputerNum()
        var playerNum = ""

        while (playerNum != computerNum) {
            playerNum = number.getPlayerNum()
            result.getScore(computerNum, playerNum)
            result.printResult(result.ball, result.strike)
        }

        result.gameAgainOrExit()
    }
}