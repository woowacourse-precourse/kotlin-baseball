package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun printStartNotice() {
    print("숫자 야구 게임을 시작합니다.")
}

fun createAnswer(): MutableList<Int> {
    val answer = mutableListOf<Int>()

    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber)
        }
    }
    return answer
}
