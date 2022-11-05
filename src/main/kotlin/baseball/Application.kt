package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = createComputerNumber()

}

fun createComputerNumber() {
    val computerNumber = ArrayList<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
}
