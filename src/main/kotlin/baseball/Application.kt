package baseball

var chooseGameNum = 1

fun main() {
    var number = Number()
    var result = Result()
    chooseGameNum = 1
    println("숫자 야구 게임을 시작합니다.")

    while (chooseGameNum == 1) {
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