package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println(comRandomNum())
}

fun comRandomNum() : String {
    var computer = ""

    while(computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!computer.contains(randomNumber.toString())) {
            computer += randomNumber.toString()
        }
    }
    return computer
}

fun inputUserNum() {
    print("숫자를 입력해주세요 : ")
    val userNum = readLine()
}

fun compareUserAndCom(com : String, user : String) {
    val comBalls = Balls(com)

    printResult(comBalls.playGame(user))
}

fun printResult(gameResult : GameResult) {

    when {
        gameResult.strike == 0 && gameResult.ball == 0 -> println("낫싱")
        gameResult.strike == 0 -> println("${gameResult.ball}볼")
        gameResult.ball == 0 -> println("${gameResult.strike}스트라이크")
        else -> println("${gameResult.ball}볼 ${gameResult.strike}스트라이크")
    }

}
