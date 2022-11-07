package baseball

import camp.nextstep.edu.missionutils.Randoms

class CreateNumber {
    fun create() {
        InputNumber().input(numberCreate())
    }
}

private fun numberCreate(): String {
    val numberList = mutableListOf<Int>()
    while (numberList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber)
        }
    }
    return numberList.joinToString("")
}


