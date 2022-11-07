package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    gameStart()
    return
}

private fun gameStart() {
    while (true) {
        playNumBaseBall()
    }
}

private fun playNumBaseBall() {
    var com: String = makeRandomNumber()

    var user: String

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        // 숫자 입력
        print("숫자를 입력해주세요 : ")
        user = Console.readLine()!!

        // 입력값 검증
        val regex = "^[1-9]{3}$".toRegex()
        if (regex.find(user) == null || user.toSet().size < 3) {
            throw IllegalArgumentException()
        }
        // 판정
        checkStrikeOrBall(user, com)
        if (user == com) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}

private fun makeRandomNumber(): String {
    var com: String

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    com = "${computer[0]}${computer[1]}${computer[2]}"

    return com
}

private fun checkStrikeOrBall(user: String, com: String) {
    var strike = 0
    var ball = 0

    for ((i, v) in user.withIndex()) {
        if (com[i] == v) {
            strike++
        } else if (v in com) {
            ball++
        }
    }
    if (ball == 0 && strike == 0) {
        println("낫싱")
    } else if (ball == 0) {
        println("${strike}스트라이크")
    } else if (strike == 0) {
        println("${ball}볼")
    } else {
        println("${ball}볼 ${strike}스트라이크")
    }
}
