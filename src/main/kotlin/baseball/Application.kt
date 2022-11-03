package baseball

import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
}
fun strikeRandNumCreate(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun inputNum(): String {
    print("숫자를 입력해주세요 : ")
    val userNum = camp.nextstep.edu.missionutils.Console.readLine()
    checkInputValid(userNum)

    return userNum
}
fun checkInputValid(user_num: String): Boolean {
    if (user_num.length != 3)
        return false
    for (i in user_num) {
        if (!(i in '1'..'9')){
            throw IllegalArgumentException("1 부터 9까지의 값을 입력해 주세요")
            return false}
    }
    return true
}

fun main() {

}
