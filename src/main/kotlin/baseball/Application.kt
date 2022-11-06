package baseball

var ball = 0
var strike = 0
var chooseGameNum = 1

fun main() {
    var number = Number()
    var calculate = Calculate()
    chooseGameNum = 1
    println("숫자 야구 게임을 시작합니다.")

    while (chooseGameNum == 1) {
        var computerNum = number.getComputerNum()
        var playerNum = ""
        while (playerNum != computerNum) {
            playerNum = number.getPlayerNum()
            calculate.getScore(computerNum, playerNum)
            calculate.printResult(ball, strike)
        }
        calculate.gameAgainOrExit()
    }
}