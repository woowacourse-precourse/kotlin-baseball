package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    TODO("프로그램 구현")


}

fun randomMaker(): Int {
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    var randomNumber2: Int
    var randomNumber3: Int

    do {
        randomNumber2 = Randoms.pickNumberInRange(1, 9)
    } while (randomNumber == randomNumber2)

    do {
        randomNumber3 = Randoms.pickNumberInRange(1, 9)
    } while (randomNumber == randomNumber3 || randomNumber3 == randomNumber2)

    return 100 * randomNumber + 10 * randomNumber2 + randomNumber3

}
