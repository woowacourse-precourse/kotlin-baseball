package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computer: String = ""
    computer = randomNum()

}

fun randomNum(): String {
    var computer: String = ""
    while (computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber.toString())) {
            computer += randomNumber
        }
    }
    return computer

}