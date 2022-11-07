package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
//    TODO("프로그램 구현")
}

fun checkInputIsCorrect(userNum: String) {
    val regex = Regex("[0-9]{3}")
    require(userNum.matches(regex)) {
        "$userNum 3자리가 아니거나, 숫자가 아닌 값"
    }
    require(userNum.toCharArray().distinct().size == 3) {
        "$userNum 각각 다른 3자리 숫자가 아님"
    }
}


/** 3개의 각각 다른 랜덤 값 생성한다. */
fun makeRandomNum(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
