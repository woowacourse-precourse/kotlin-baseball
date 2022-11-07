package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // 시작
    while (true) {
        // 랜덤 숫자 3개 받아오기
        val computer = randomThreeNumber()


    }
}


// 랜덤 3글자 추출
private fun randomThreeNumber(): String {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (randomNumber !in computer) computer.add(randomNumber)
    }

    println(computer)

    return computer.joinToString("")
}
