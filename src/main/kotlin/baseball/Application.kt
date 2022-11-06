package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun chooseComputerNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        var randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        addComputerNumber(randomNumber, computerNumber)
    }
    return computerNumber
}

/* 뽑은 랜덤 숫자의 중복 여부를 확인하고 아닐 시 리스트에 추가하는 메소드  */
fun addComputerNumber(randomNumber: Int, computerNumber: MutableList<Int>) {
    if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber)
    }
}

fun printFirstStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}
