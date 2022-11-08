package baseball

import baseball.computer.createComputerRandomNumber
import baseball.referee.judgeStrikeAndBallCount
import baseball.user.setUpGameOver

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    gameStart()
}

fun gameStart(){
    val computerRandomNumber = createComputerRandomNumber()
    var strike=0

    while (strike !=3) strike = judgeStrikeAndBallCount(computerRandomNumber)

    when (setUpGameOver(strike)) {
        "1" -> gameStart()
    }

}
