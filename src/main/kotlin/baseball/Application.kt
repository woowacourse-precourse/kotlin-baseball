package baseball

import camp.nextstep.edu.missionutils.Randoms

var randomNum = 0

fun main() {
    print("숫자 야구 게임을 시작합니다.")
    randomNum = makeRandomNumber()
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

private fun isThreeDigitNum(num: Int) = num in (100..999)

private fun existZero(num: Int) = num.toString().contains('0')

private fun isDifferentNum(num: Int): Boolean {
    val set = mutableSetOf<Char>()
    num.toString().map {
        set.add(it)
    }
    return set.size == 3
}