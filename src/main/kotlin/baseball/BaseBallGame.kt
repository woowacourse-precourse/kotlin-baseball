package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    while (true) {
        val computer = makeRandomBallNumbers()
        println("숫자 야구 게임을 시작합니다.")
        playGame(computer)
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val reGame = Console.readLine()
        if (reGame == "2") break
    }
}

private fun makeRandomBallNumbers(): MutableList<Int> {
    val computer = mutableListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playGame(computer: Any) {
    TODO("Not yet implemented")
}
