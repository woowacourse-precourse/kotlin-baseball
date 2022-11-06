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

fun checkNum(playerNum: String) {
    if (playerNum.length != 3) {
        throw IllegalArgumentException("세자리 수를 입력해주세요.")
    }
    if (playerNum.contains("0")) {
        throw IllegalArgumentException("1~9사이 숫자를 입력해주세요.")
    }
    for (i in 0..1) {
        if (playerNum[i] == playerNum[i + 1]) {
            throw IllegalArgumentException("서로 다른 숫자를 입력해주세요.")
        }
    }
}