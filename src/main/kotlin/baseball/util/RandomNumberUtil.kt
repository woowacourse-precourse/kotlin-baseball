package baseball.util

import camp.nextstep.edu.missionutils.Randoms

fun createRandomNumber(): String {
    var computerNum = ""
    while (computerNum.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber.toString())) {
            computerNum += randomNumber
        }
    }
    return computerNum
}