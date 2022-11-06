package baseball

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {
    fun generateNotDuplicatedNumber(computerNumbers: List<Int>): Int {
        var randomNumber = Randoms.pickNumberInRange(1, 9)
        while (computerNumbers.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9)
        }
        return randomNumber
    }
}