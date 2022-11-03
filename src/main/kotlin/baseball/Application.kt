package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val computerNumber = mutableListOf<Int>()
    createComputerNumber(computerNumber)

    val userNumber: List<Int> = readUserNumber()

    val isNothing = checkNothing(userNumber, computerNumber)

    if (isNothing)
        println("낫싱")
    if (!isNothing) {
        val strike = checkStrike(userNumber, computerNumber)
        println(strike)
    }






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
fun checkNothing(userNumber: List<Int>, computerNumber: MutableList<Int>): Boolean {
    for (num in userNumber.indices)
        if (computerNumber.contains(userNumber[num]))
            return false
    return true
}
fun checkStrike(userNumber: List<Int>, computerNumber: MutableList<Int>): Int {
    var countStrike = 0

    for (num in userNumber.indices)
        if (computerNumber[num] == userNumber[num])
            countStrike++

    return countStrike
}