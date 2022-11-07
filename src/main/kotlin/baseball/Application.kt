package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    println("숫자 야구 게임을 시작합니다.")
}

fun computerNumber() : List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playerNumber() : List<Int>{
    print("숫자를 입력해주세요 :")
    val playerInput = Console.readLine()!!

    val player = mutableListOf<Int>()
    playerInput.forEach { player.add(it-'0') }

    return player
}

