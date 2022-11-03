package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val randomNumber = makeRandomNumber()
    print("숫자 야구 게임을 시작합니다.")
    while(true){
        // TODO: 기능 구현하기
    }
}

private fun makeRandomNumber(): Int {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("").toInt()
}