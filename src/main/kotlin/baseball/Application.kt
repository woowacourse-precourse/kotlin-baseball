package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val computerNumber = mutableListOf<Int>()
    createComputerNumber(computerNumber)




}
fun createComputerNumber(computerNumber: MutableList<Int>){
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber))
            computerNumber.add(randomNumber)
    }
}
