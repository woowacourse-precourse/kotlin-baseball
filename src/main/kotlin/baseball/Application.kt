package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    print(getRandomNumbers(1,9,3))

}

fun getRandomNumbers(randomStartNumber:Int,randomEndNumber:Int,randomsLength:Int): List<Int> {
    return Randoms.pickUniqueNumbersInRange(randomStartNumber,randomEndNumber,randomsLength)
}