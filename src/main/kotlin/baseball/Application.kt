package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var comNum = comRandomNum()

    while(true) {
        val userNum = inputUserNum()

        val num = compareUserAndCom(comNum, userNum!!)

        when(num) {
            1 -> comNum = comRandomNum()
            2 -> break
        }
    }
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

fun inputUserNum() : String? {
    print("숫자를 입력해주세요 : ")
    return readLine()
}

fun compareUserAndCom(com : String, user : String) : Int {
    val comBalls = Balls(com)
    val result = printResult(comBalls.playGame(user))

    println(result)
    if(result.equals("3스트라이크")) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readLine()!!.toInt()
    }
    return 0
}

fun printResult(gameResult : GameResult) : String{

    var result = ""
    when {
        gameResult.strike == 0 && gameResult.ball == 0 -> result = "낫싱"
        gameResult.strike == 0 -> result = "${gameResult.ball}볼"
        gameResult.ball == 0 -> result = "${gameResult.strike}스트라이크"
        else -> result = "${gameResult.ball}볼 ${gameResult.strike}스트라이크"
    }
    return result
}

