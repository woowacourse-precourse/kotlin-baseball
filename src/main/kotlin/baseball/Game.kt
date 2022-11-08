package baseball

import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    val computerNumber = createComputerNumber()
    while (true) {
        printMessageAskingForInputNumber()
    }
}

fun createComputerNumber(): String {
    val computerNumber = mutableListOf<Int>()

    while (computerNumber.size < 3) {
        var pickedNumber = Randoms.pickNumberInRange(1, 9)
        while (computerNumber.contains(pickedNumber))
            pickedNumber = Randoms.pickNumberInRange(1, 9)
        computerNumber.add(pickedNumber)
    }

    return computerNumber.joinToString("")
}