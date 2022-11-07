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
