package baseball.computer

import camp.nextstep.edu.missionutils.Randoms

fun createComputerRandomNumber(): String {

    val computerNumStringList = mutableListOf<String>()

    while (computerNumStringList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumStringList.contains(randomNumber.toString())) {
            computerNumStringList.add(randomNumber.toString())
        }
    }

    return computerNumStringList.joinToString("")
}
