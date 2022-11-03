package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val computerNumber = mutableListOf<Int>()
    createComputerNumber(computerNumber)

    val userNumber: List<Int> = readUserNumber()






}
fun createComputerNumber(computerNumber: MutableList<Int>){
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber))
            computerNumber.add(randomNumber)
    }
}
fun readUserNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    return Console.readLine().map { it.digitToInt() }
}